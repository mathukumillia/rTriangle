/**
 * HTree
 *
 * 		recursively draws an HTree
 *
 */

import java.awt.Graphics;

public class rTriangle{
	
	private x1, y1, x2, y2, x3, y3, depth;
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
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.depth = 1;
	}

}