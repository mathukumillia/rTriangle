/**
 * rTriangle
 *
 * 		recursively draws an r
 *
 */

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class rTriangle{
	
	private int centerx, centery, x, y, z, depth, x1, x2, x3, y1, y2, y3;
	private Graphics g;

	public static final int MAX_DEPTH = 7;

	/**
	 * constructor
	 *
	 * 		@param x - center x position of the htree 
	 * 		@param y - center y position of the htree 
	 * 		@param length - length of the largest H's middle bar
	 */
	public rTriangle(int a, int b, int width, int height){

		centerx = width/2;
		centery = height/2;
		x = (int)(0.8 * (Math.min(width/2, height/2)));
		y = (int)(x * Math.sin(Math.PI/6));
		z = (int)(Math.sqrt((x*x) - (y*y)));
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("z: " + z);
		System.out.println("centerx: " + centerx);
		System.out.println("centery: " + centery);
		this.depth = 1;

		x1 = centerx - z;
		y1 = centery + y;
		x2 = centerx;
		y2 = centery - x;
		x3 = centerx + z;
		y3 = centery + y;
		
	}

	/**
	 *   getters(setters are not useful)
	 */
	
	public int getCenterX(){
		return centerx;
	}
	public int getCenterY(){
		return centery;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getZ(){
		return z;
	}
	

	/**
	 * incrementDepth
	 *
	 * 		increment the depth by one, unless the depth is greater than or equal to MAX_DEPTH, in which case it should be set to one
	 * 
	 */
	public void incrementDepth(){
		if(depth == MAX_DEPTH){
			depth = 1;
		}else{
			depth++;
		}
	}

	/**
	 * draw
	 * 		draw the rTriangle to the screen 
	 * 		this is an accessor method that calls the real private recursive method
	 *
	 * @param g - the Graphics object associated with the window
	 */
	public void draw(Graphics g){
		this.g = g;
		recursiveDraw(depth);
	}

	/**
	 *recursiveDraw
	 *		actually draw the htree
	 *
	 * @param n - the current depth of the rTriangle
	 * @param x1, y1 - coordinates of starting bottom left point
	 * @param x2, y2 - coordinates of starting top point
	 * @param x3, y3 - coordinates of starting bottom right point
	 * 
	 *
	 * precondition - g must not be null
	 *  
	 */
	private void recursiveDraw(int n){
		//base case
		if(n <= 0){
			return;
		}

		Polygon t = new Polygon();
		t.addPoint(x1, y1);
		t.addPoint(x2, y2);
		t.addPoint(x3, y3);
		g.setColor(Color.black);
		g.drawPolygon(t);
		g.setColor(Color.white);
		g.fillPolygon(t);
		
		int tempx = x1;
		int tempy = y1;
			//System.out.println("previous x1: " + x1);
		x1 = (x2 + x1)/2;
			//System.out.println("processed x1: " + x1);
			//System.out.println("previous y1: " + y1);
		y1 = (y2 + y1)/2;
			//System.out.println("processed y1: " + y1);
			//System.out.println("previous x2: " + x2);
		x2 = (x3 + x2)/2;
			//System.out.println("processed x2: " + x2);
			//System.out.println("previous y2: " + y2);
		y2 = (y3 + y2)/2;
			//System.out.println("processed y2: " + y2);
			//System.out.println("previous x3: " + x3);
		x3 = (tempx + x3)/2;
			//System.out.println("processed x3: " + x3);
			//System.out.println("previous y3: " + y3);
		y3 = (tempy + y3)/2;
			//System.out.println("processed y3: " + y3);
			//System.out.println();	

		recursiveDraw(n-1);
	} 
}