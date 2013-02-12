/**
 * rTriangle
 *
 * 		recursively draws an r
 *
 */

import java.awt.Graphics;

public class rTriangle{
	
	private int x1, y1, x2, y2, x3, y3, depth;
	private Graphics g;

	public static final int MAX_DEPTH = 7;

	/**
	 * constructor
	 *
	 * 		@param x - center x position of the htree 
	 * 		@param y - center y position of the htree 
	 * 		@param length - length of the largest H's middle bar
	 */
	public rTriangle(int x1, int y1, int x2, int y2, int x3, int y3){

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.depth = 1;
	}

	/**
	 *   getters and setters
	 */
	
	public void setX1(int x){
		this.x1 = x;
	}
	public int getX1(){
		return x1;
	}
	public void setX2(int x){
		this.x2 = x;
	}
	public int getX2(){
		return x2;
	}
	public void setX3(int x){
		this.x3 = x;
	}
	public int getX3(){
		return x3;
	}
	public void setY1(int y){
		this.y1 = y;
	}
	public int getY1(){
		return y1;
	}
	public void setY2(int y){
		this.y2 = y;
	}
	public int getY2(){
		return y2;
	}
	public void setY3(int y){
		this.y3 = y;
	}
	public int getY3(){
		return y3;
	}
	public int getDepth(){
		return depth;
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
		recursiveDraw(depth, x1, y1, x2, y2, x3, y3);
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
	private void recursiveDraw(int n, int x1, int y1, int x2, int y2, int x3, int y3){
		//base case
		if(n <= 0){
			return;
		}

		int tempx;
		int tempy;
		//find midpoint of existing three sides
		tempx = x1;
		tempy = y1;
		x1 = ((x1 + x2) / 2);
		y1 = ((y1 + y2) / 2);
		x2 = ((x2 + x3) / 2);
		y2 = ((y2 + y3) / 2);
		x3 = ((x3 + tempx) / 2);
		y3 = ((y1 + tempy) / 2);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x3, y3, x1, y1);

		recursiveDraw(n-1, x1, y1, x2, y2, x3, y3);
	}
}