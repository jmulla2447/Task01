package com.okapi.org.service;

import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Service
public class MatrixService {
    private final MatrixRepository matrixRepository;

    @Autowired
    public MatrixService(MatrixRepository matrixRepository) {
        this.matrixRepository = matrixRepository;
    }

    public void saveCameraBitMatrixToDatabase(int[][] matrix) {
        MatrixEntity matrixEntity = new MatrixEntity();
        matrixEntity.setData(matrix);
        matrixRepository.save(matrixEntity);
    }

    public int countItemsFromDatabase() {
        long count = matrixRepository.findAll().stream()
                .mapToInt(matrix -> countItems(matrix.getData()))
                .sum();

        return Math.toIntExact(count);
    }

    private static int countItems(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        AtomicInteger count = new AtomicInteger(0);

        IntStream.range(0, numRows)
                .flatMap(row -> IntStream.range(0, numCols)
                        .filter(col -> matrix[row][col] == 1 && !visited[row][col])
                        .peek(col -> {
                            count.getAndIncrement();
                            exploreItem(matrix, visited, row, col);
                        }))
                .forEach(col -> {
                });

        return count.get();
    }

    private static void exploreItem(int[][] matrix, boolean[][] visited, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if (row < 0 || col < 0 || row >= numRows || col >= numCols || matrix[row][col] != 1 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        exploreItem(matrix, visited, row - 1, col);
        exploreItem(matrix, visited, row + 1, col);
        exploreItem(matrix, visited, row, col - 1);
        exploreItem(matrix, visited, row, col + 1);
    }

}
