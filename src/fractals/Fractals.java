package fractals;
import javax.swing.JFrame;

public class Fractals {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Fractals!");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Comp());
		frame.setVisible(true);
		
	}
	
	
}
