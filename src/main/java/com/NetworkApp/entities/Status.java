package com.NetworkApp.entities;

public class Status {
    private int idStatus;

    private String statusName;

    public Status(int idStatus, String statusName) {
        this.idStatus = idStatus;
        this.statusName = statusName;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName){
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return idStatus == status.idStatus && statusName.equals(status.statusName);
    }

    @Override
    public int hashCode() {
        return 31 * idStatus + statusName.hashCode();
    }

    @Override
    public String toString() {
        return "Status {" + "ID = " + idStatus + ", Name = '" + statusName + '}';
    }

}

