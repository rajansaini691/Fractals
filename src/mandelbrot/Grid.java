package mandelbrot;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The Grid is basically a collection of pixels
 * 
 * @author Rajan Saini
 *
 */
public class Grid {
	private Pixel[][] pixels;
	private BufferedImage screen;
	
	/**
	 * Creates a new Grid object. 
	 * @param pixels This must already be filled.
	 */
	public Grid(Pixel[][] pixels) {
		this.pixels = pixels;
		this.screen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
	}
	
	public void draw(Graphics2D win) {
		for(int i = 0; i < screen.getWidth(); i++) {
			for(int j = 0; j < screen.getHeight(); j++) {
				pixels[i][j].update();
				screen.setRGB(i, j, pixels[i][j].getColor().getRGB());
			}
		}
		win.drawImage(screen, 0, 0, null);
	}
	
	/**
	 * Zooms into the screen
	 * @param x The x coordinate of zoom center
	 * @param y The y Coordinate of zoom center
	 */
	public void zoom(int x, int y) {
		double a = pixels[x][y].getComplexNumber().getA(); 
		double b = pixels[x][y].getComplexNumber().getB();
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j].zoom(a, b);
			}
		}
	}
	
	/**
	 * Zooms out of the screen
	 * @param x The x coordinate of zoom center
	 * @param y The y Coordinate of zoom center
	 */
	public void zoomOut(int x, int y) {
		double a = pixels[x][y].getComplexNumber().getA(); 
		double b = pixels[x][y].getComplexNumber().getB();
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j].zoomOut(a, b);
			}
		}
	}
	
	//TODO JavaDoc
	public ComplexNumber getCoords(int x, int y) {
		return pixels[x][y].getComplexNumber().clone();
	}
	
	//TODO JavaDoc
	public void setPixels(Pixel[][] pixels) {
		this.pixels = pixels;
	}
	
	public Pixel[][] getPixels() {
		return pixels;
	}
	
	
}
