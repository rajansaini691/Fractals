package mandelbrot;

import java.awt.Color;

public abstract class Pixel {
	/*
	 * MAX_BOUND determines when each pixel will escape
	 */
	protected static final double MAX_BOUND = 4;
	
	/*
	 * Defines the center of the screen
	 */
	private static int A = 400, B = 300;
	
	/*
	 * Sets initial scaling of pixel
	 */
	private final static double WEIGHT = 0.01;
	
	/*
	 * The color of the pixel; gets drawn
	 */
	protected Color myColor;
	
	/*
	 * Pixel's complex number
	 */
	private ComplexNumber c;
	
	/*
	 * Coordinates of the pixel
	 */
	protected int x,y;
	
	
	
	public Pixel(int x, int y) {
		this.x = x; 
		this.y = y;
		c = new ComplexNumber((x - A) * WEIGHT, (y - B) * WEIGHT);
		myColor = calculateColorValue();
	}
	
	public abstract Color calculateColorValue();
	
	public Color getColor() {
		return myColor;
	}
	
	public void zoom(double a, double b) {
		c.set((c.getA() + a) / 2.0, (c.getB() + b) / 2.0);
	}
	
	public void zoomOut(double a, double b) {
		c.set((c.getA() - a) * 1.5 + a, (c.getB() - b) * 1.5 + b);
	}
	
	public void update() {
		myColor = calculateColorValue();
	}
	
	public ComplexNumber getComplexNumber() {
		return c;
	}
	
}
