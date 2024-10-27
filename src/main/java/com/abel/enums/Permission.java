package com.abel.enums;

public enum Permission {

    CLIENT_READ("client:read"),
    CLIENT_CREATE("client:create"),
    CLIENT_UPDATE("client:update"),
    CLIENT_DELETE("client:delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
