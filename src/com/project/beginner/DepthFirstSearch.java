package com.project.beginner;

import java.awt.Point;
import java.util.List;

public class DepthFirstSearch {

    // This method searches for a path in the maze using Depth First Search (DFS).
    // Parameters:
    // maze   : 2D integer array representing the maze grid.
    // row    : current row position in the maze.
    // col    : current column position in the maze.
    // path   : list of Points storing the solution path from start to destination.
    public static boolean searchPath(int[][] maze, int row, int col, List<Point> path) {

        // Check if the current position is out of maze boundaries.
        // If it is outside, return false because it is not a valid path.
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) return false;

        // Check if the current cell is the destination.
        // In the maze, the destination is represented by the value 9.
        if (maze[row][col] == 9) {
            // Add the destination cell to the path.
            path.add(new Point(row, col));
            return true; // Path found
        }

        // Only proceed if the current cell is free (value 0).
        if (maze[row][col] == 0) {
            maze[row][col] = 2; // Mark the cell as visited to avoid revisiting it.

            // Recursively explore all four possible directions:
            // up, down, left, and right.
            // If any direction leads to the destination, the current cell is part of the path.
            if (searchPath(maze, row - 1, col, path) || // up
                searchPath(maze, row + 1, col, path) || // down
                searchPath(maze, row, col - 1, path) || // left
                searchPath(maze, row, col + 1, path)) { // right
                // Add the current cell to the path as it is part of the solution.
                path.add(new Point(row, col));
                return true; // Path exists through this cell
            }
        }

        // If the cell is not free or no valid path is found through it, return false.
        return false;
    }
}
