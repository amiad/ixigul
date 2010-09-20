package main;

//Import the swing and AWT classes needed
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
 
/**
 * Basic Swing board.
 */
public class SwingBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8987482015113385894L;

	public static void main(String[] args) {
		SwingBoard f = new SwingBoard();
	    f.setTitle("ixigul - graphics version");
	    f.setSize(600, 600);
	    f.setBackground(Color.green);
	    f.setVisible(true);
	  }
	  
	  public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D)g;
	    
//	    g2.setPaint(Color.black);
//	    g2.drawLine(50, 50, 150, 100);
//	    g2.drawString("hello world", 40, 40);
	    
	    g2.setStroke(new BasicStroke(3));
	    Line2D l1 = new Line2D.Double(200, 0, 200, 600);
	    g2.draw(l1);
	    l1 = new Line2D.Double(400, 0, 400, 600);
	    g2.draw(l1);
	    l1 = new Line2D.Double(0, 200, 600, 200);
	    g2.draw(l1);
	    l1 = new Line2D.Double(0, 400, 600, 400);
	    g2.draw(l1);
	    
	    
/*	    double x = 15, y = 50, w = 70, h = 70;
	    Ellipse2D e = new Ellipse2D.Double(x, y, w, h);
	    GradientPaint gp = new GradientPaint(75, 75, Color.white,
	        95, 95, Color.gray, true);
	    // Fill with a gradient.
	    g2.setPaint(gp);
	    g2.fill(e);
	    // Stroke with a solid color.
	    e.setFrame(x + 100, y, w, h);
	    g2.setPaint(Color.black);
	    g2.setStroke(new BasicStroke(8));
	    g2.draw(e);
	    // Stroke with a gradient.
	    e.setFrame(x + 200, y, w, h);
	    g2.setPaint(gp);
	    g2.draw(e);
*/
	  }
	}


