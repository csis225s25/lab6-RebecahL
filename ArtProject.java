import java.awt.*;
import javax.swing.*;
/**
 * A custom JPanel that overrides paintComponent to draw a 3D house with a sun and a tree.
 * Demonstrates various Graphics methods like drawRect, fillRect, drawPolygon, fillPolygon, 
 * drawOval, and fillOval to create a more detailed scene.
 * 
 * @author Rebecah Leonard and Katie Morseman
 * @version 2/27/25
 */

 class HousePanel extends JPanel {

    /**
     * Overrides the paintComponent method to draw a 3D house with a sun and a tree.
     * @param g The Graphics object used for drawing shapes.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        // Set background color
        setBackground(Color.CYAN);

        // Draw the sun (top-right corner)
        g.setColor(Color.YELLOW);
        g.fillOval(getWidth() - 100, 20, 80, 80); // Yellow sun

        // Draw the ground
        g.setColor(Color.GREEN);
        g.fillRect(0, 350, getWidth(), 150); // Grass at the bottom

        // ==== 3D House ====
        // House front face using a polygon
        g.setColor(Color.BLUE);
        int[] xBaseFront = {150, 150, 350, 350}; // X-coordinates
        int[] yBaseFront = {200, 350, 350, 200}; // Y-coordinates
        g.fillPolygon(xBaseFront, yBaseFront, 4); // House front wall

        // Side face for 3D effect (polygon)
        g.setColor(new Color(50, 50, 255)); // Darker blue for shading
        int[] xBaseSide = {350, 400, 400, 350}; // X-coordinates
        int[] yBaseSide = {200, 200, 350, 350};// Y-coordinates
        g.fillPolygon(xBaseSide, yBaseSide, 4); // House right-side wall

        // Roof (3D perspective)
        g.setColor(Color.RED);
        int[] xRoof = {140, 260, 380};  // X-coordinates for front roof
        int[] yRoof = {200, 100, 200};  // Y-coordinates
        g.fillPolygon(xRoof, yRoof, 3); // Filled front roof

        g.setColor(new Color(180, 0, 0)); // Darker red for 3D side roof
        int[] xSideRoof = {260, 380, 400, 350}; // X-coordinates for side roof
        int[] ySideRoof = {100, 200, 200, 130};  // Y-coordinates
        g.fillPolygon(xSideRoof, ySideRoof, 4); // Filled side roof

        // Door
        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(225, 270, 50, 80); // Door

        // Windows
        g.setColor(Color.WHITE);
        g.fillRect(170, 220, 40, 40); // Left window
        g.fillRect(290, 220, 40, 40); // Right window
        g.fillRect(360, 240, 30, 30); // Side window

        // ==== Tree ====
        // Trunk
        g.setColor(new Color(101, 67, 33)); // Brown tree trunk
        g.fillRect(60, 270, 30, 80);

        // Leaves (using filled ovals)
        g.setColor(Color.GREEN);
        g.fillOval(30, 230, 90, 50);
        g.fillOval(40, 200, 80, 50);
        g.fillOval(20, 250, 100, 50);

        // ==== Pathway to the door ====
        g.setColor(Color.GRAY);
        g.fillRect(235, 350, 30, 50); // Small pathway
    }
}

/**
 * The main class that creates a JFrame and adds the HousePanel to display the scene.
 * Implements the Runnable interface for thread-safe execution.
 */
public class ArtProject implements Runnable {

    /**
     * Sets up the JFrame and adds the custom HousePanel.
     */
    @Override
    public void run() {
        JFrame frame = new JFrame("3D House with Sun and Tree");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom panel to the frame
        JPanel panel = new HousePanel();
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The main method that starts the Swing application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ArtProject());
    }
}
