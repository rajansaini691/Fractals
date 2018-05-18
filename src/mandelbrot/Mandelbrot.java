package mandelbrot;

import javax.swing.JFrame;

public class Mandelbrot {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Mandelbrot");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MComp());
		frame.setVisible(true);
	}

}
