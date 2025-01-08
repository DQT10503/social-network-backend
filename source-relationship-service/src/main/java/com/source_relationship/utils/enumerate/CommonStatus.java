package com.source_relationship.utils.enumerate;

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
}
