package com.NetworkApp.entities;

public class Administrator {
    private String login;

    private String password;

    public Administrator(String password, String login) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator {" + "Login ='" + login + ", Password = '" + password + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator admin = (Administrator) o;

        if (login != null ? !login.equals(admin.login) : admin.login != null) return false;
        return password != null ? password.equals(admin.password) : admin.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
