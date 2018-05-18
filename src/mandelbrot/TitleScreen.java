package mandelbrot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TitleScreen {
	private static Font titleFont = new Font("Century Gothic", Font.BOLD, 75);
	private static Font subTitleFont = new Font("Century Gothic", Font.BOLD, 40);
	private static Font menuFont = new Font("Century Gothic", Font.BOLD, 50);
	
	public void draw(Graphics2D win) {
		drawBackground(win);
		drawTitle(win);
		drawSubtitle(win);
		drawMenu(win);
	}
	
	private void drawBackground(Graphics2D win) {
		win.setColor(Color.WHITE);
		win.fillRect(0, 0, 800, 600);
	}
	
	private void drawTitle(Graphics2D win) {
		win.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		win.setFont(titleFont);
		win.setColor(Color.BLACK);
		win.drawString("Complex Fractals", 65, 140);
		
	}
	
	private void drawSubtitle(Graphics2D win) {
		win.setFont(subTitleFont);
		win.drawString("By Rajan Saini", 240, 200);
	}
	
	private void drawMenu(Graphics2D win) {
		win.setFont(menuFont);
		win.drawString("Mandelbrot", 235, 320);
		win.drawString("Julia", 320, 420);
	}
	
	
}
