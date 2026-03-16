import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    // Controls how many levels of branches the tree has
    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Start drawing from the bottom middle of the window
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        // -90 degrees makes the first branch go straight up
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursive method that draws a branch, then splits
     * into two smaller branches.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {

        // ---- Base Case ----
        // When depth reaches 0, stop making more branches
        if (depth == 0) {
            return;
        }

        // Make branch length smaller each level so the tree tapers
        int length = depth * 12;

        // Convert the angle to radians for Java trig functions
        double radians = Math.toRadians(angle);

        // Calculate where the branch should end
        int x2 = x1 + (int) (length * Math.cos(radians));
        int y2 = y1 + (int) (length * Math.sin(radians));

        // Draw the current branch
        g.drawLine(x1, y1, x2, y2);

        // ---- Recursive Calls ----
        // From the end of this branch, grow two smaller ones

        // Left branch
        drawTree(g, x2, y2, angle - 20, depth - 1);

        // Right branch
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {

        // Create the window for the fractal tree
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        frame.add(new FractalTree());

        // Centers the window on screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
