package com.NetworkApp.model;

import com.NetworkApp.entities.Status;

import java.util.Map;

public class ModelStatusTable {
    private Map<Integer, Status> model;
    public void getData(Status status) {
        model.put(status.getIdStatus(), status);
    }
}