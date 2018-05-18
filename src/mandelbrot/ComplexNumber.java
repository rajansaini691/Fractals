package mandelbrot;

public class ComplexNumber {

	public final static ComplexNumber ZERO = new ComplexNumber(0, 0);

	private double a, b;

	public ComplexNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public ComplexNumber() {
		this.a = 0;
		this.b = 0;
	}

	public void set(ComplexNumber num) {
		this.a = num.getA();
		this.b = num.getB();
	}

	public void set(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getMagnitudeSquared() {
		return a * a + b * b;
	}

	public void square() {
		double tempA = a, tempB = b;
		a = tempA * tempA - tempB * tempB;
		b = 2 * tempB * tempA;
	}

	public ComplexNumber add(ComplexNumber num) {
		return new ComplexNumber(num.getA() + a, num.getB() + b);
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public ComplexNumber clone() {
		return new ComplexNumber(a, b);
	}

}
