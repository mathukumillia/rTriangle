/**
 * rTriangle
 *
 * 		recursively draws an r
 *
 */

import java.awt.Graphics;
import java.awt.Polygon;

public class rTriangle{
	
	private int centerx, centery, x, y, z, depth;
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
		x = (int)(0.9 * (Math.min(width/2, height/2)));
		y = (int)(x * Math.sin(Math.PI/6));
		z = (int)(Math.sqrt((x*x) - (y*y)));
		System.out.println("centerx: " + centerx + " centery: " + centery + " x: " + x + " y: "+ y + " z: " + z);
		this.depth = 1;
		
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
		
		int x1 = centerx - z;
		int y1 = centery + y;
		int x2 = centerx;
		int y2 = centery - x;
		int x3 = centerx + z;
		int y3 = centery + y;

		if(n <= 0){
			return;
		}

		Polygon t = new Polygon();
		t.addPoint(x1, y1);
		t.addPoint(x2, y2);
		t.addPoint(x3, y3);
		g.fillPolygon(t);
		

		recursiveDraw(n-1);
	}
}