package mandelbrot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class JuliaWaitingScreen {
	
	private Font titleFont = new Font("Century Gothic", Font.BOLD, 50);
	
	public JuliaWaitingScreen() {
		
	}
	
	public void draw(Graphics2D win) {
		//Draw background and init
		win.setColor(Color.BLACK);
		win.fillRect(0, 0, 800, 600);
		win.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draw title
		win.setFont(titleFont);
		win.setColor(Color.WHITE);
		win.drawString("Enter desired Julia coords", 80, 100);
		win.drawString("the console", 240, 200);
	}
}
