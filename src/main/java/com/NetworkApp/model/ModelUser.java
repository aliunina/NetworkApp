package com.NetworkApp.model;

import com.NetworkApp.entities.User;

import java.util.HashMap;
import java.util.Map;

public class ModelUser {
    private static ModelUser instance = new ModelUser();

    private Map<String, String> model;

    public static ModelUser getInstance() {
        return instance;
    }

    private ModelUser() {
        model = new HashMap<>();
    }

    public void add(User user) {
        model.put(user.getPassword(),  user.getLogin());
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
