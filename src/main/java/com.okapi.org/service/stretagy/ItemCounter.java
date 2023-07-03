package com.okapi.org.service.stretagy;

import com.okapi.org.model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ItemCounter {
    private CountingStrategy strategy;

    public ItemCounter(){}

    public ItemCounter(boolean isDiagoanl){
        if(isDiagoanl){
            setCountingStrategy(new DiagonalCountingStrategy());
        }else {
            setCountingStrategy(new OrthogonalCountingStrategy());
        }
    }
    private void setCountingStrategy(CountingStrategy strategy) {
        this.strategy = strategy;
    }

    public int countItems(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        List<List<Vertex>> allItems = new ArrayList<>();

        IntStream.range(0, numRows)
                .forEach(row -> IntStream.range(0, numCols)
                        .filter(col -> matrix[row][col] == 1 && !visited[row][col])
                        .forEach(col -> allItems.add(strategy.exploreItem(matrix, visited, row, col, new ArrayList<Vertex>()))));

        return allItems.size();
    }
}
