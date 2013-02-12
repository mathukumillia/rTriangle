import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.event.*;

class rTriangleWindow extends JFrame implements MouseListener {
	
	private rTriangle triangle = null;
	
	// double buffering objects
	// used to eliminate flicker when resizing window
    private Image offscreen; 
	private Graphics buffer;

	/**
	 * Constructor
	 * 
	 * @param width - width of the window
	 * @param height - height of the window
	 * @param depth - recursive depth of the HTree
	 */
	public rTriangleWindow(int width, int height) {
		super("rTriangleWindow");
		this.setBounds(200, 200, width, height);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setVisible(true);
	}

	/**
	 * paint
	 * 		draws the contents of the window
	 * 
	 * 		called automatically when the window needs updating
	 */
	@Override
	public void paint(Graphics g){
		reset();

		triangle.draw(buffer);

		g.drawImage(offscreen, 0, 0, this);
	}

	/**
	 * reset
	 *		clear the background, 
	 *		center and scale the triangle dependent on the dimensions of the window
	 */
	private void reset() {
		Rectangle b = this.getBounds();
		
		offscreen = createImage(b.width,b.height);
		buffer = offscreen.getGraphics();
		buffer.setColor(Color.white);
		
		buffer.clearRect(0,0,b.width,b.height); 
		
		if (triangle == null) { // tree not created yet 
			triangle = new rTriangle(b.width/3, (b.height/3) * 2, (b.width/3) * 2, (b.height/3), b.width, (b.height/3) * 2);
		} else {
			triangle.setX1(b.width / 2);
			triangle.setY1(b.height / 2 + 12);
		}
	}

	/**
	 * update
	 * 		paint the window on each update,
	 * 		necessary for double buffering
	 */
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	/**
	 * main
	 * 		create an rTriangle window with an appropriate recursive depth
	 * 
	 * @param args - args[1] is the depth of recursion
	 */
	public static void main(String[] args) {
		rTriangleWindow rtwin = new rTriangleWindow(600, 520);

	}

	/**
	 * incrementDepth
	 * 		increase the depth of the rTriangle, up to a point
	 */
	public void incrementDepth() {
		triangle.incrementDepth();
		repaint();
	}


	/**
	 * mouseClicked
	 * 		mouse was clicked (pressed and released) on the window
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 * 
	 * @param e - object holding info about the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		incrementDepth();
	}


	/**
	 * mousePressed
	 * 		mouse was pressed down
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * mouseReleased
	 * 		mouse was released after a press
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * mouseEntered
	 * 		mouse entered the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * mouseExited
	 * 		mouse exited the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseExited(MouseEvent e) {

	}

}