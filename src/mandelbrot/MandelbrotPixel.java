package mandelbrot;

import java.awt.Color;

public class MandelbrotPixel extends Pixel {

	public MandelbrotPixel(int x, int y) {
		super(x, y);
	}
	
	//Recursive method that returns an integer representing the number of iterations before leaving the bound
	private double getEscape(ComplexNumber z, double n, ComplexNumber c) {
		if(z.getMagnitudeSquared() > MAX_BOUND) {
			return n;
		} else if(n > 100) {
			return 0;
		} else {
			z.square();
			z.set(z.add(c));
			return getEscape(z.clone(), n + 1, c);
		}
	}
	
	@Override
	public Color calculateColorValue() {
		double escape = getEscape(new ComplexNumber(0, 0), 0, this.getComplexNumber());
		int colorScale = (int) (escape * 2.5);
		return new Color(0, colorScale, colorScale);
	}

}
