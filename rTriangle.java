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
	
	private int centerx, centery, x, y, z, depth;
	private int[] coord = new int[6];
	private int[] sCoord = new int[6];
	private Graphics g;

	public static final int MAX_DEPTH = 7;

	/**
	 * constructor
	 *
	 * 		@param width - width of the window
	 * 		@param height - height of the window 
	 */
	public rTriangle(int width, int height){

		centerx = width/2;
		centery = height/2;
		x = (int)(0.8 * (Math.min(width/2, height/2)));
		y = (int)(x * Math.sin(Math.PI/6));
		z = (int)(Math.sqrt((x*x) - (y*y)));
		this.depth = 1;

		coord[0] = centerx - z;
		coord[1] = centery + y;
		coord[2] = centerx;
		coord[3] = centery - x;
		coord[4] = centerx + z;
		coord[5] = centery + y;

		sCoord = drawTriangle(coord[0], coord[1], coord[2], coord[3], coord[4], coord[5]);
		
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
		int x1 = sCoord[0];
		int y1 = sCoord[1];
		int x2 = sCoord[2];
		int y2 = sCoord[3];
		int x3 = sCoord[4];
		int y3 = sCoord[5];
		sCoord = drawTriangle(x1,y1,x2,y2,x3,y3);
		//recursiveDraw(depth, coord[0], coord[1], coord[2], coord[3], coord[4], coord[5], Color.white);
		//recursiveDraw(depth, x1, y1, sCoord[0], sCoord[1], sCoord[4], sCoord[5], Color.white);
		recursiveDraw(depth, sCoord[0], sCoord[1], x2, y2, sCoord[2], sCoord[3], Color.white);
		//recursiveDraw(depth, sCoord[4], sCoord[5], sCoord[2], sCoord[3], x3, y3, Color.white);
	}

	/**
	 *recursiveDraw
	 *		actually draw the htree
	 *
	 * @param n - the current depth of the rTriangle
	 * @param x1, y1 - coordinates of starting bottom left point
	 * @param x2, y2 - coordinates of starting top point
	 * @param x3, y3 - coordinates of starting bottom right point
	 * @param color - color of the triangle being painted
	 * 
	 *
	 * precondition - g must not be null
	 *  
	 */
	private void recursiveDraw(int n, int x1, int y1, int x2, int y2, int x3, int y3, Color color){
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
		g.setColor(color);
		g.fillPolygon(t);
		
		sCoord[0] = (x2 + x1)/2;
		sCoord[1] = (y2 + y1)/2;	
		sCoord[2] = (x3 + x2)/2;
		sCoord[3] = (y3 + y2)/2;
		sCoord[4] = (x1 + x3)/2;
		sCoord[5] = (y1 + y3)/2;

		System.out.println("n = " + n);
			
		for(int i = 0; i<sCoord.length; i++){
			System.out.println("sCoord of " + i + " is " + sCoord[i]);
		} 
		System.out.println();
		System.out.println();

		recursiveDraw(n-1, sCoord[0], sCoord[1], sCoord[2], sCoord[3], sCoord[4], sCoord[5], Color.white);	
	} 
	public int[] drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
		int tempx = x1;
		int tempy = y1;
		int[] sTri = new int[6];

		System.out.println("This is the draw triangle method");
		sTri[0] = (x2 + x1)/2;
		sTri[1] = (y2 + y1)/2;	
		sTri[2] = (x3 + x2)/2;
		sTri[3] = (y3 + y2)/2;
		sTri[4] = (x1 + x3)/2;
		sTri[5] = (y1 + y3)/2;

		return sTri;
	}
}