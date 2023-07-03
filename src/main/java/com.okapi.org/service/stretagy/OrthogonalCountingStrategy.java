package com.okapi.org.service.stretagy;

import com.okapi.org.model.Vertex;

import java.util.List;

public class OrthogonalCountingStrategy implements CountingStrategy {
    @Override
    public List<Vertex> exploreItem(int[][] matrix, boolean[][] visited, int row, int col, List<Vertex> item) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if (row < 0 || col < 0 || row >= numRows || col >= numCols || matrix[row][col] != 1 || visited[row][col]) {
            return item;
        }

        item.add(new Vertex(row,col));
        visited[row][col] = true;

        exploreItem(matrix, visited, row - 1, col, item);
        exploreItem(matrix, visited, row + 1, col, item);
        exploreItem(matrix, visited, row, col - 1, item);
        exploreItem(matrix, visited, row, col + 1, item);

        return item;
    }
}
