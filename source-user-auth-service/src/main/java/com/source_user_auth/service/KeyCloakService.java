package com.source_user_auth.service;

import com.source_user_auth.utils.enummerate.RoleEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class KeyCloakService {

    private final WebClient webClient;
    @Value("${keycloak.auth-server-url}")
    private String baseUrl;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientName;
    private final String clientId = "5ac8d9f3-a9f1-4875-9e96-c97018b81ad9";

    public KeyCloakService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/").build();
    }

    /**
     * 1.  Khởi tạo một request POST
     * 2. Define URL API: đây là endpoint của Keycloak để lấy access token
     * 3. Thêm Header: Keycloak yêu cầu dữ liệu gửi lên dạng "application/x-www-form-urlencoded"
     * 4. Gửi Body: dữ liệu được gửi lên Keycloak dưới dạng URL-encoded
     * 5. .retrieve():  Gửi Request và nhận Response từ Keycloak
     * 6. .bodyToMono(Map.class): chuyển dữ liệu phản hồi từ JSON sang kiểu Map
     * 7. Lấy giá trị của access_token
     */

    private String getAdminToken() {
        // Retrofit;
        String token = webClient.post()
                .uri("/realms/" + realm + "/protocol/openid-connect/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .bodyValue("client_id=" + clientName + "&username=quocthinh3050@gmail.com&password=12345&grant_type=password&client_secret=DOD3RdOGYPtvFbpdEvMofTaoDzBT0s8X")
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> response.get("access_token").toString())
                .block();
        return token;
    }

    public Mono<Void> createUserInKeycloak(String name, String email, String username, String password, String phone) {
        String token = String.valueOf(getAdminToken());
        System.out.println("Token: " + token);
        // Tạo user
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", username);
        userMap.put("email", email);
        userMap.put("enabled", true);
        userMap.put("firstName", name.split(" ")[0]);
        userMap.put("lastName", name.substring(name.indexOf(" ") + 1));
        userMap.put("attributes", Collections.singletonMap("phone", phone)); // lưu phone vào attributes với key là "phone"; tạo một Map chỉ có một cặp key-value

        // Tạo danh sách credentials
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("type", "password");
        credentials.put("value", password);
        credentials.put("temporary", false); // không bắt buộc user đổi mật khẩu khi đăng nhập lần đầu

        List<Map<String, Object>> credentialsList = new ArrayList<>();
        credentialsList.add(credentials); // thêm credentials vào List vì trong Keycloak, credentials là một list
        userMap.put("credentials", credentialsList); // thêm list credentials vào userMap

        return webClient.post()
                .uri("/admin/realms/" + realm + "/users")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(userMap)
                .retrieve()
                .bodyToMono(Void.class)
                .then(getUserId(username, token))
                .flatMap(userId -> getClientRole(String.valueOf(RoleEnum.ROLE_USER).toLowerCase(), token)
                        .flatMap(role -> assignRoleToUser(userId, role, token)));
    }

    private Mono<String> getUserId(String username, String token) {
        return webClient.get()
                .uri("/admin/realms/" + realm + "/users?username=" + username)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .bodyToMono(List.class)
                .map(user -> ((Map<String, Object>) user.get(0)).get("id").toString());
    }

    private Mono<Map<String, Object>> getClientRole(String roleName, String token) {
        return webClient.get()
                .uri("/admin/realms/" + realm + "/clients/" + clientId + "/roles/" + roleName)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});
    }

    private Mono<Void> assignRoleToUser(String userId, Map<String, Object> role, String token) {
        return webClient.post()
                .uri("/admin/realms/" + realm + "/users/" + userId + "/role-mappings/clients" + clientId)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(Collections.singletonList(role))
                .retrieve()
                .bodyToMono(Void.class);
    }
}
