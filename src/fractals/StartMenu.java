package fractals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartMenu implements KeyListener {

	private Comp comp;
	
	public StartMenu(Comp comp) {
		this.comp = comp;
	}
	
	public void draw(Graphics2D win) {
		win.setColor(Color.WHITE);
		win.drawString("1: Square, 2: Triangle, 3: Tree, 4: Line", 100, 100);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {	
		case KeyEvent.VK_1:
			comp.gameState = 1;
			break;
		case KeyEvent.VK_2:
			comp.gameState = 2;
			break;
		case KeyEvent.VK_3:
			comp.gameState = 3;
			break;
		case KeyEvent.VK_4:
			comp.gameState = 4;
			break;
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
