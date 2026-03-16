public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the maze so we can see the progress.
     * Helpful for debugging and seeing the final path.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Finds where the starting point 'S' is located
     * and then begins the recursive search from there.
     */
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;

        // Look through the maze to find 'S'
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        // If we found the start, begin solving from that spot
        if (startRow != -1) {
            return solve(startRow, startCol);
        }

        // If no start exists, maze can't be solved
        return false;
    }

    /**
     * Recursive backtracking method.
     * Tries to move through the maze until it either
     * finds the finish or hits a dead end.
     */
    private boolean solve(int row, int col) {

        // ---- Base Cases ----

        // If we're outside the maze, stop
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }

        // If we hit a wall or a visited path, stop exploring
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // If we reached the finish, we're done!
        if (maze[row][col] == 'F') {
            return true;
        }

        // Mark the current space so we don't revisit it
        // (basically leaving breadcrumbs)
        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }

        // ---- Recursive Exploration ----
        // Try moving in all four directions

        // North
        if (solve(row - 1, col)) return true;

        // East
        if (solve(row, col + 1)) return true;

        // South
        if (solve(row + 1, col)) return true;

        // West
        if (solve(row, col - 1)) return true;

        // ---- Backtracking ----
        // If none of the directions worked, this path is a dead end.
        // Reset the space so other paths can use it later.
        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }

        return false;
    }

    public static void main(String[] args) {

        // Maze that HAS a solution
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }

        solver.printMaze();

        // ---- Second test maze (no solution) ----
        char[][] unsolvableMaze = {
            {'#', '#', '#', '#', '#'},
            {'#', 'S', '#', 'F', '#'},
            {'#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(unsolvableMaze);

        System.out.println("Second Maze:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }

        solver2.printMaze();
    }
}
