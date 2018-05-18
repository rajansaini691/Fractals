package mandelbrot;

import java.awt.Color;

public class JuliaPixel extends Pixel {
	
	public JuliaPixel(int x, int y) {
		super(x, y);
	}
	
	private double getEscape(ComplexNumber z, int n, ComplexNumber c) {
		if(z.getMagnitudeSquared() > MAX_BOUND) {
			return n;
		} else if(n > 100) {
			return 0;
		} else {
			ComplexNumber newZ = z.clone();
			newZ.square();
			newZ.set(newZ.add(c));
			return getEscape(newZ, n + 1, c);
		}
	}

	@Override
	public Color calculateColorValue() {
		double escape = getEscape(this.getComplexNumber(), 0, new ComplexNumber(0.3, 0));
		int colorScale = (int) (escape * 2.5);
		return new Color(0, colorScale, colorScale);
	}

}
