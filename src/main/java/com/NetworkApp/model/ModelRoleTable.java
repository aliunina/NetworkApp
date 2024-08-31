package com.NetworkApp.model;

import com.NetworkApp.entities.Role;

import java.util.Map;

public class ModelRoleTable {
    private Map<Integer, Role> model;
    public void getData(Role role) {
        model.put(role.getRoleId(), role);
    }
}