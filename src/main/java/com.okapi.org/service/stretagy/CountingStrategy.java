package com.okapi.org.service.stretagy;

import com.okapi.org.model.Vertex;

import java.util.List;

public interface CountingStrategy {
    List<Vertex> exploreItem(int[][] matrix, boolean[][] visited, int row, int col, List<Vertex> item);
}
