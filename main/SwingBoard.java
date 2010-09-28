package main;

//Import the swing and AWT classes needed
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
 
/**
 * Basic Swing board.
 */
public class SwingBoard extends JFrame {

	public SwingBoard(){
		this.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.NOBUTTON) {
				System.out.println("No button clicked...");
			} else if (e.getButton() == MouseEvent.BUTTON1) {
				System.out.println("Button 1 clicked...");
			} else if (e.getButton() == MouseEvent.BUTTON2) {
				System.out.println("Button 2 clicked...");
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				System.out.println("Button 3 clicked...");
			}
			
			System.out.println("Number of click: " + e.getClickCount());
			System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
			point2Cell(e.getX(), e.getY());
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
		
		
		this.addComponentListener(new ComponentListener() {
			
			public void componentHidden(ComponentEvent e) {
				System.out.println("componentHidden event from " + e.getComponent().getClass().getName());
			}
			
			public void componentMoved(ComponentEvent e) {
				Component c = e.getComponent();
				System.out.println("componentMoved event from " + c.getClass().getName()
						+ "; new location: " + c.getLocation().x + ", " + c.getLocation().y);
			}
			
			public void componentResized(ComponentEvent e) {
				Component c = e.getComponent();
				System.out.println("componentResized event from " + c.getClass().getName() + "; new size: "
						+ c.getSize().width + ", " + c.getSize().height);
			}
			
			public void componentShown(ComponentEvent e) {
				System.out.println("componentShown event from " + e.getComponent().getClass().getName());
			}
		
		});
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8987482015113385894L;

	public static void main(String[] args) {
		SwingBoard f = new SwingBoard();
		f.setTitle("ixigul - graphics version");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setVisible(true);		
	}
	
	public void repaint(int x, int y, int z, int w){
		paint(this.getGraphics());
	}

	/**
	 * 
	 * @param x x position of mouse
	 * @param y y position of mouse
	 * @return integer between 0 and 8, representing the cell that the mouse located in
	 */
	private int point2Cell(int x, int y){

		int cellWidth = getWidth()/3;
		int cellHeight = getHeight()/3;
		int row, col;
		
		if (x <= cellWidth)
			col = 0;
		else if (x <= cellWidth * 2)
			col = 1;
		else
			col = 2;
		
		if (y <= cellHeight)
			row = 0;
		else if (y <= cellHeight *2)
			row = 1;
		else
			row = 2;
		
		System.out.println(row * 3 + col);
		return row * 3 + col;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponents(g2);
		this.point2Cell(getX(), getY());
	    		
		int cellWidth = getWidth()/3;
		int cellHeight = getHeight()/3;

		
		// Set green background
		g2.setColor(Color.green);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		// Width of line = 3
		g2.setStroke(new BasicStroke(3));
		
		// Draw borders between cells
		g2.setColor(Color.black);
		g2.drawLine(cellWidth, 0, cellWidth, cellHeight * 3);
		g2.drawLine(cellWidth * 2, 0, cellWidth * 2, cellHeight * 3);
		g2.drawLine(0, cellHeight, cellWidth * 3, cellHeight);
		g2.drawLine(0, cellHeight * 2, cellWidth * 3, cellHeight *2);

		// Set cells images properties (X/O image size and location)
		int left1, left2, left3, top1, top2, top3, imgSize;
		imgSize = Math.min(cellWidth, cellHeight) - 70;
		left1 = (cellWidth - imgSize)/2;
		left2 = left1 + cellWidth;
		left3 = left2 + cellWidth;
		top1 = (cellHeight - imgSize)/2;
		top2 = top1 + cellHeight;
		top3 = top2 + cellHeight;
		
		
		// Trying to write X and O in big font
		g2.setFont(new Font("Dialog", Font.PLAIN,(int) (imgSize*1.37)));
		g2.drawString("X", left1, top1+imgSize);
		g2.drawString("O", left2, top3+imgSize);
		
				
	} // paint function
} // class

