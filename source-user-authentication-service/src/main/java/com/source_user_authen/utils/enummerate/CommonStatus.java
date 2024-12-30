package com.source_user_authen.utils.enummerate;

public enum CommonStatus {
    ACTIVE("Đang hoạt động")
  , INACTIVE("Ngừng hoạt động");

    private String value;

    CommonStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
