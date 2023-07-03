package com.okapi.org.model;

public class Vertex {
    private int x;
    private int y;

    public Vertex() {
    }

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
