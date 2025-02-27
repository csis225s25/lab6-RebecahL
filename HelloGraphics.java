import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Rebecah Leonard and Katie Morseman 
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {
    public GraphicsPanel() { 
        // Set background color for the panel
        setBackground(Color.LIGHT_GRAY);
        // Set foreground color (used for drawing text)
        setForeground(Color.RED);
    }
    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        
        // Define a new font (change name, style, and size)
         Font customFont = new Font("Serif", Font.BOLD | Font.ITALIC, 30);
         g.setFont(customFont);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        String text = "Hello, Java Graphics World!";
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getAscent(); // Height above the baseline

        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2;

        g.drawString(text, x,y);
    }
}

public class HelloGraphics implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
