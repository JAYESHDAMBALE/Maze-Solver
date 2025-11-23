🧩 Maze Solver in Java (DFS Algorithm)

Welcome to the Maze Solver project! This application demonstrates how to solve a 2D maze using Depth First Search (DFS) in Java, with a simple and clean Java Swing GUI to visualize the maze and the pathfinding process.

🚀 Project Overview

This project focuses on building a Maze Solver (ME Solver) that:

Represents a maze using a 2D grid

Identifies a starting point and an ending point

Uses the DFS algorithm to find a valid path

Displays the maze and the solution path using an interactive GUI

The goal is to find a valid path from the source to the destination, avoiding obstacles.

🗺️ Maze Representation

The maze is created using a 2D integer array:

Value	Meaning
0	Free path (traversable)
1	Obstacle (blocked)
9	Destination

All boundaries of the maze are typically set as 1 to prevent out-of-bounds traversal.

✨ Features
✔️ User Interface (UI)

Developed using Java Swing

Simple and clean JFrame-based GUI

Visual grid with:

🟩 Path cells

⬛ Traversable blocks

⬜ Obstacles

🎯 Destination marker

✔️ Pathfinding Logic

Implemented using Depth First Search (DFS)

Automatically marks visited cells

Backtracking implemented for blocked paths

Returns the complete solution path as a list of coordinates

✔️ Project Structure

Separate class for GUI (Swing)

Separate class for DFS logic

Integrated to visually display the final path from start → destination

🧠 Algorithm Used: DFS (Depth First Search)

DFS is used to explore the grid deeply before backtracking, making it suitable for this maze:

Recursively explores all possible directions

Tracks visited cells to avoid infinite loops

Stops when destination (9) is reached

Stores the entire successful path in a list

🔧 How It Works

The application loads the 2D grid.

The DFS method is called with:

Starting coordinates

Maze grid

Grid width

DFS searches until the destination (9) is found.

All valid coordinates are stored in a path list.

The GUI highlights the path visually.

The path list contains both X and Y coordinates in alternating order:

[x1, y1, x2, y2, x3, y3, ...]

📂 Tech Stack

Java (Core language)

Java Swing (GUI)

Eclipise (IDE used for development)

🖼️ Live Demo (Optional)

<img width="526" height="582" alt="Screenshot of maze solver" src="https://github.com/user-attachments/assets/762fda04-01e4-434a-bbb4-b1ec352649e8" />

📁 File Structure (Suggested)
Maze-Solver/
├── src/
│   ├── mazeSolverProject.java
│   ├── DFS.java
│   ├── GridPanel.java
│   └── ...
├── README.md
└── images

▶️ How to Run

Clone the repository:

git clone https://github.com/<your-username>/<repo-name>.git


Open the project in NetBeans / IntelliJ / Eclipse

Run the main file:

mazeSolverProject.java
