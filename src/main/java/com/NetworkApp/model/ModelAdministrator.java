package com.NetworkApp.model;

import com.NetworkApp.entities.Administrator;

import java.util.HashMap;
import java.util.Map;

public class ModelAdministrator {
    private static ModelAdministrator instance = new ModelAdministrator();

    private Map<String, String> model;

    public static ModelAdministrator getInstance() {
        return instance;
    }

    private ModelAdministrator() {
        model = new HashMap<>();
        model.put("12345", "admin");
    }

    public void add(Administrator admin) {
        model.put(admin.getPassword(), admin.getLogin());
    }

    public Map<String, String> list() {
        return model;
    }

    public boolean checkLoginAndPassword(String password, String login) {
        return (model.containsKey(password) && model.containsValue(login));
    }
    public boolean checkLogin(String login) {
        return (model.containsValue(login));
    }
}
