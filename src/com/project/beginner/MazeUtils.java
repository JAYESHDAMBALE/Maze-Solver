package com.project.beginner;

public class MazeUtils {

    // This method generates a random maze with the given number of rows and columns.
    // It returns a 2D integer array where:
    // 0 represents an open path,
    // 1 represents a wall,
    // 9 represents the exit of the maze.
    public static int[][] generateRandomMaze(int rows, int cols) {
        int[][] maze = new int[rows][cols];

        // Fill the entire maze with walls initially.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = 1;
            }
        }

        // Start carving paths using a recursive DFS-like algorithm
        // starting from cell (1,1).
        carve(maze, 1, 1, rows, cols);

        // Mark the exit point at the bottom-right of the maze.
        // The exit is represented by the number 9.
        maze[rows - 2][cols - 2] = 9;

        return maze;
    }

    // Private helper method to recursively carve paths in the maze.
    // Parameters:
    // maze : 2D array representing the maze
    // r, c : current row and column being carved
    // rows, cols : dimensions of the maze
    private static void carve(int[][] maze, int r, int c, int rows, int cols) {
        // Define movement offsets for four directions: up, down, left, right.
        int[] dr = { -2, 2, 0, 0 }; // change in row
        int[] dc = { 0, 0, -2, 2 }; // change in column

        // Create an array of indices to shuffle the order of directions randomly.
        Integer[] order = {0, 1, 2, 3};
        java.util.Collections.shuffle(java.util.Arrays.asList(order));

        // Explore each direction in the shuffled order.
        for (int i : order) {
            int nr = r + dr[i]; // new row after moving
            int nc = c + dc[i]; // new column after moving

            // Check if the new cell is within bounds and is still a wall
            if (nr > 0 && nr < rows - 1 && nc > 0 && nc < cols - 1 && maze[nr][nc] == 1) {
                // Remove the wall between the current cell and the new cell.
                maze[r + dr[i] / 2][c + dc[i] / 2] = 0;

                // Mark the new cell as an open path.
                maze[nr][nc] = 0;

                // Recursively carve from the new cell.
                carve(maze, nr, nc, rows, cols);
            }
        }
    }
}
