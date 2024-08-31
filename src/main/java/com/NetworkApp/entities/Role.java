package com.NetworkApp.entities;

public class Role {
    private int roleId;

    private String roleName;

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId && roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        return 31 * roleId + roleName.hashCode();
    }

    @Override
    public String toString() {
        return "Role {" + "ID=" + roleId + ", Name='" + roleName + '}';
    }
}
