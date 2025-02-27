import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Rebecah Leonard and Katie Morseman
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {

	String toDisplay;
    int counter = 0;
    JPanel panel;
    JButton resetButton;

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates a frame panel that holds graphics panel and reset button
        JPanel framePanel = new JPanel(new BorderLayout());

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new JPanel() {

            /**
            * Overrides the paintComponent method to draw a string stating the mouse press count
            * @param g The Graphics object used for drawing.
            */
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Mouse press count: " + counter;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);

			}

                
		};

        //creates a reset button that is displayed in the bottom center of the framePanel
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        framePanel.add(resetButton,BorderLayout.SOUTH);

        //graphics panel is added to the frame panel
        framePanel.add(panel,BorderLayout.CENTER);
        panel.addMouseListener(this);

        //the framePanel is added to the frame
        frame.add(framePanel,BorderLayout.CENTER);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    /**
     * Updates counter if mouse is clicked
     * 
     * @param e the MouseEvent
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked: " + e);
        counter++;
        panel.repaint();
	}

    /**
     * Resets counter to 0 if the reset button is pressed
     * 
     * @param e the ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("action performed");
        if(e.getSource()==resetButton){
            counter = 0;
            panel.repaint();
        }
    }


	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
