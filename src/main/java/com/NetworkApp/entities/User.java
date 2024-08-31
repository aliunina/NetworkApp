package com.NetworkApp.entities;

public class User {
    private int userId;

    private Status status;

    private Role role;

    private String name;

    private String surname;

    private String patronymic;

    private String email;

    private String phoneNumber;

    private String login;

    private String password;

    public User(int userId, Status status, Role role, String name, String surname,
                String patronymic, String email, String phoneNumber, String login,
                String password) {
        this.userId = userId;
        this.role = role;
        this.status = status;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public int getUserId () {
        return userId;
    }

    public void setUserId (int UserId) {
        userId = UserId;
    }

    public Role getRole () {
        return role;
    }

    public void setRole (Role RoleId) {
         role = RoleId;
    }

    public Status getStatus () {
        return status;
    }

    public void setStatus (Status StatusId) {
         status = StatusId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname){
        this.surname = surname;
    }

    public String getPatronymic () {
        return patronymic;
    }

    public void setPatronymic (String patronymic){
        this.surname = patronymic;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login){
        this.login = login;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPassword () {
        return password;
    }

    @Override
    public String toString() {
        return "User {" +
                "ID = " + userId +
                ", StatusID = " + status +
                ", RoleID = " + role +
                ", Name='" + name+
                ", Surname='" + surname +
                ", Patronymic='" + patronymic +
                ", Email='" + email +
                ", PhoneNumber='" + phoneNumber +
                ", Login='" + login +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

}