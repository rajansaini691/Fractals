package fractals;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Comp extends GameDriverV3 implements KeyListener {
	
	double divider = 4;
	boolean increasing = true;
	double theta = Math.PI / 4;
	int size = 300;
	int gameState = 0; //0 - menu; 1 - square; 2 - triangle; 3 - tree; 4 - line
	StartMenu menu = new StartMenu(this);
	
	public Comp() {
		recurse1("himynameisrajan");
		this.addKeyListener(menu);
		this.addKeyListener(this);
	}
	
	@Override
	public void draw(Graphics2D win) {
		win.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		win.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		
		win.setColor(Color.BLACK);
		win.fillRect(0, 0, 800, 600);
		win.setColor(Color.WHITE);
		
		switch(gameState) {
		case 0:
			menu.draw(win);
			break;
		case 1:
			drawSquareFractal(200, 200, 200, 200, win);
			break;
		case 2:
			drawTriangle(550, 100, 540, win);
			break;
		case 3:
			drawTreeFractal(200, 300, 550, theta, win);
			theta -= 0.01;
			break;
		case 4:
			drawLine(size, 300, 300, false, win);
			break;
		}
		
	}
	
	public void drawLine(double length, double x, double y, boolean isUp, Graphics2D win) {
		if(length < 10) {
			return;
		} else {
			double newLength = length / 1.5;
			if(isUp) {
				win.drawLine((int) x, (int) y, (int) x, (int) (y - length));
				
				drawLine(newLength, x - newLength / 2, y - length, false, win);
				drawLine(newLength, x - newLength / 2, y, false, win);
			} else {
				win.drawLine((int) x, (int) y, (int) (x + length), (int) y);
				drawLine(newLength, x, y + newLength / 2, true, win);
				drawLine(newLength, x + length, y + newLength / 2, true, win);
			}
			
			
		}
	}
	
	public void recurse1(String name) {
		System.out.println(name);
		if(name.length() > 1) {
			recurse2(name.substring(2));
		}
	}
	public void recurse2(String name) {
		System.out.println(name);
		if(name.length() > 1) {
			name += "a";
			recurse1(name);
		}
	}
	
	public void drawTreeFractal(int length, int x0, int y0, double theta, Graphics2D win) {
		win.drawLine(x0, y0, x0, y0 - length);
		
		double newLength = length / 1.4;
		
		drawTree(x0, y0 - length, newLength, theta, theta, win);
		
		
	}
	
	private void drawTree(int x0, int y0, double length, double theta, double initialTheta, Graphics2D win) {
		if(length <= 5) {
			return;
		} else {
			int newX = (int) (x0 + length * Math.sin(theta));
			int newY = (int) (y0 - length * Math.cos(theta));
			
			win.drawLine(x0, y0, newX, newY);
			win.drawLine(x0, y0, newX, newY);
		
			drawTree(newX, newY, length / 1.4, theta + initialTheta, initialTheta, win);
			drawTree(newX, newY, length / 1.4, theta - initialTheta, initialTheta, win);
		}
	}
	
	//Wrapper method - draws the outer triangle and then the fractal inside
	private void drawTriangle(int length, int x0, int y0, Graphics2D win) {
		win.drawLine(x0, y0, x0 + length/2, (int) (y0 - ((double) length * Math.sqrt(3) / 2)));
		win.drawLine(x0, y0, x0 + length, y0);
		win.drawLine(x0 + length, y0, x0 + length/2, (int) (y0 - length * ((double) Math.sqrt(3) / 2)));
		
		drawTriangleFractal(length / 2, x0 + length / 4, y0 - (int) ((double) length * Math.sqrt(3) / 4), win);
	
	}
	
	private void drawTriangleFractal(int length, int x0, int y0, Graphics2D win) {
		if(length <= 8) {
			return;
		} else {
			win.drawLine(x0, y0, x0 + length/2, (int) (y0 + length * ((double) Math.sqrt(3) / 2)));
			win.drawLine(x0, y0, x0 + length, y0);
			win.drawLine(x0 + length, y0, x0 + length/2, (int) (y0 + length * ((double) Math.sqrt(3) / 2)));
			
			drawTriangleFractal(length / 2, x0 + length / 4, y0 - (int) ((double) length * Math.sqrt(3) / 4), win);
		}
	}
	
	//Animates drawSquare
	private void drawSquareFractal(double x, double y, double width, double height, Graphics2D win) {
		drawSquare(x, y, width, height, divider, win);
		if(divider <= 2.5) {
			increasing = false;
		}
		
		if(divider >= 4) {
			increasing = true;
		}
		
		if(increasing) {
			divider -= 0.01;
		} else {
			divider += 0.01;
		}
	}
	
	//Draws a square fractal
	private void drawSquare(double x, double y, double width, double height, double divider, Graphics2D win) {
		if(width < 2) {
			return;
		} else {
			double newWidth = width / divider;
			double newHeight = height / divider;
			double padding = width / divider;
			
			win.fillRect((int) x, (int) y, (int) width, (int) height);
			
			//Top left
			drawSquare(x - newWidth - padding, y - newHeight - padding, newWidth, newHeight, divider, win);
			
			//Top right
			drawSquare(x + width + padding, y - newHeight - padding, newWidth, newHeight, divider, win);
			
		 	//Bottom left
			drawSquare(x - newWidth - padding, y + height + padding, newWidth, newHeight, divider, win);
			
			//Bottom right
			drawSquare(x + width + padding, y + height + padding, newWidth, newHeight, divider, win);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			gameState = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
