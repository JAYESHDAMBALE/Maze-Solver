package com.project.beginner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initial maze size
        int rows = 21;
        int cols = 21;
        int tileSize = 25;

        // Generate initial random maze
        int[][] maze = MazeUtils.generateRandomMaze(rows, cols);
        List<Point> path = new ArrayList<>();
        DepthFirstSearch.searchPath(maze, 1, 1, path);
        java.util.Collections.reverse(path);

        // Create JFrame
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create MazePanel
        MazePanel mazePanel = new MazePanel(maze, path, tileSize);
        frame.add(mazePanel, BorderLayout.CENTER);

        // Create "Random Maze" button
        JButton randomButton = new JButton("Generate Random Maze");
        frame.add(randomButton, BorderLayout.SOUTH);

        // Add action listener to button
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate new random maze
                int[][] newMaze = MazeUtils.generateRandomMaze(rows, cols);

                // Find path
                List<Point> newPath = new ArrayList<>();
                DepthFirstSearch.searchPath(newMaze, 1, 1, newPath);
                java.util.Collections.reverse(newPath);

                // Update MazePanel with new maze and path
                mazePanel.updateMaze(newMaze, newPath);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
