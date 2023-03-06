package maths.polynome;

public class Monome {
	private int exposant;
	private double coef;

	public Monome(int exposant, double coef) {
		this.exposant = exposant;
		this.coef = coef;
	}

	public int getExposant() {
		return this.exposant;
	}

	public double getCoef() {
		return this.coef;
	}

	public void setExposant(int e) {
		this.exposant = e;
	}

	public void setCoef(double c) {
		this.coef = c;
	}
}