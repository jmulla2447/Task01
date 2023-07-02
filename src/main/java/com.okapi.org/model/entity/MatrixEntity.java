package com.okapi.org.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("camera_matrix")
public class MatrixEntity {
    @Id
    private String id;
    private int[][] data;

    public MatrixEntity() {
    }

    public MatrixEntity(String id, int[][] data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
}
