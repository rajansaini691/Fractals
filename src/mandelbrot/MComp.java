package mandelbrot;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class MComp extends GameDriverV3 implements MouseListener, KeyListener, MouseMotionListener {

	private BufferedImage screen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
	private MandelbrotPixel[][] mPixels = new MandelbrotPixel[screen.getWidth()][screen.getHeight()];
	private JuliaPixel[][] jPixels = new JuliaPixel[screen.getWidth()][screen.getHeight()];
	private Grid grid;
	
	//Draw screens
	private TitleScreen titleScreen = new TitleScreen();
	private JuliaWaitingScreen jwScreen = new JuliaWaitingScreen();
	/*
	 * Toggles command mode
	 * TODO - Print the coordinates you are clicking to the screen
	 *      - Get some sort of way to notify the user that you are in command mode
	 *      	Maybe have the music change, since a repaint would be too costly
	 */
	boolean space = false;
	boolean commandMode = false;
	
	//TODO Implement this. When you change states from 2 to 3, call the changePixels method
	private int state = 0; // 0 - Title, 1 - Draw Mandelbrot, 2 - Waiting for Julia, 3 - Draw Julia
	
	public MComp() {
		for(int i = 0; i < screen.getWidth(); i++) {
			for(int j = 0; j < screen.getHeight(); j++) {
				mPixels[i][j] = new MandelbrotPixel(i, j);
				jPixels[i][j] = new JuliaPixel(i, j);
			}
		}
		grid = new Grid(jPixels);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this); 
	}
	
	@Override
	public void draw(Graphics2D win) {
		switch(state) {
		case 0:
			titleScreen.draw(win);
			break;
		case 1:
			grid.draw(win);
			break;
		case 2:
			jwScreen.draw(win);
			break;
		case 3:
			grid.draw(win);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		
		if(state == 1 || state == 3) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(commandMode) {
					grid.zoom(mX, mY);
					repaint();
				} else {
					ComplexNumber coords = grid.getCoords(mX, mY);
					System.out.println("a: " + coords.getA() + " b: " + coords.getB());
				}
			} 
			if(e.getButton() == MouseEvent.BUTTON3 && !commandMode) {
				grid.zoomOut(mX, mY);
				repaint();
			}
			
		} else if(state == 0) {
			if(mX > 237 && mX < 520 && mY < 325 && mY > 274) {				//Mandlbrot TODO Debug why it doesn't switch
				state = 1;
				repaint();
			} else if(mX > 320 && mX < 430 && mY > 377 && mY < 422) {		//Julia 
				state = 3;
				repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && !space) {
			space = true;
			commandMode = !commandMode;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(state == 0) {
			//x: 320 to 430 & y: 377 to 422
			int mX = e.getX();
			int mY = e.getY();
			if((mX > 237 && mX < 520 && mY < 325 && mY > 274) || (mX > 320 && mX < 430 && mY > 377 && mY < 422)) {
				this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
}
