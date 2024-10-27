package com.abel.enums;

import java.util.List;

public enum Role {
    ADMIN(List.of(Permission.CLIENT_CREATE, Permission.CLIENT_READ, Permission.CLIENT_UPDATE, Permission.CLIENT_DELETE)),
    MANAGER(List.of(Permission.CLIENT_READ, Permission.CLIENT_UPDATE)),
    USER(List.of(Permission.CLIENT_READ));

    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
