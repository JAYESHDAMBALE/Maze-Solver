package com.project.beginner;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int[][] maze;
    private List<Point> path;
    private final int tileSize;

    public MazePanel(int[][] maze, List<Point> path, int tileSize) {
        this.maze = maze;
        this.path = path;
        this.tileSize = tileSize;
        setPreferredSize(new Dimension(maze[0].length * tileSize, maze.length * tileSize));
    }

    // Method to update the maze and path, then repaint the panel
    public void updateMaze(int[][] maze, List<Point> path) {
        this.maze = maze;
        this.path = path;
        repaint(); // Trigger paintComponent to redraw
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                switch (maze[row][col]) {
                    case 1: g.setColor(Color.BLACK); break;
                    case 9: g.setColor(Color.RED); break;
                    default: g.setColor(Color.WHITE); break;
                }
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                g.setColor(Color.GRAY);
                g.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }

        // Entry point in blue
        g.setColor(Color.BLUE);
        g.fillRect(1 * tileSize, 1 * tileSize, tileSize, tileSize);

        // Exit point in red
        g.setColor(Color.RED);
        g.fillRect((maze[0].length - 2) * tileSize, (maze.length - 2) * tileSize, tileSize, tileSize);

        // Paint solution path in green
        g.setColor(Color.GREEN);
        for (Point p : path) {
            g.fillRect(p.y * tileSize, p.x * tileSize, tileSize, tileSize);
        }
    }
}
