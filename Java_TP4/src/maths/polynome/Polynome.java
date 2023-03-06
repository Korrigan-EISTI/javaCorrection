package maths.polynome;

public class Polynome {

	// private double[] coefs;
	private Monome[] monomes;

	public Polynome(double[] coefs) {
		int nbMonomes = 0;
		for (int i = 0; i < coefs.length; i++) {
			if (coefs[i] != 0.0) {
				nbMonomes++;
			}
		}
		this.monomes = new Monome[nbMonomes];
		int numMonome = 0;
		for (int i = 0; i < coefs.length; i++) {
			if (coefs[i] != 0.0) {
				this.monomes[numMonome] = new Monome(i, coefs[i]);
				numMonome++;
			}
		}
	}

	public double get(int i) {
		double res = 0.0;
		int j = 0;
		while (j < this.monomes.length && this.monomes[j].getExposant() != i) {
			j++;
		}
		if (j < this.monomes.length) {
			res = this.monomes[j].getCoef();
		}
		return res;
	}

	public int getDegre() {
		if (this.monomes.length == 0) {
			return 0;
		} else {
			int max = this.monomes[0].getExposant();
			for (int i = 0; i < this.monomes.length; i++) {
				if (this.monomes[i].getExposant() > max) {
					max = this.monomes[i].getExposant();
				}
			}
			return max;
		}
	}

	// public Polynome(double[] coefs) {
	// int degre = coefs.length - 1;
	// while (degre >= 0 && coefs[degre] == 0.0) {
	// degre--;
	// }
	// this.coefs = new double[degre + 1];
	// for (int i = 0; i <= degre; i++) {
	// this.coefs[i] = coefs[i];
	// }
	// }

	// public int getDegre() {
	// return this.coefs.length - 1;
	// }

	// public double get(int i) {
	// if (i >= 0 && i <= this.getDegre()) {
	// return this.coefs[i];
	// } else {
	// return 0;
	// }
	// }

	public double evalue(double x) {
		double res = this.get(0);
		double puis = 1.0;
		for (int i = 1; i <= this.getDegre(); i++) {
			puis = puis * x;
			res = res + this.get(i) * puis;
		}
		return res;
	}

	public String toString() {
		String res = this.get(this.getDegre()) + "x^" + this.getDegre();
		for (int i = this.getDegre() - 1; i > 0; i--) {
			if (this.get(i) > 0) {
				res = res + "+";
			}
			if (this.get(i) != 0.0) {
				res = res + this.get(i) + "x^" + i;
			}
		}
		if (this.get(0) > 0) {
			res = res + "+";
		}
		if (this.get(0) != 0.0) {
			res = res + this.get(0);
		}
		return res;
	}

	public boolean equals(Object o) {
		if (o instanceof Polynome) {
			Polynome po = (Polynome) o;
			boolean eq = (this.getDegre() == po.getDegre());
			int i = 0;
			while (eq && i <= this.getDegre()) {
				eq = this.get(i) == po.get(i);
				i++;
			}
			return eq;
		} else {
			return false;
		}
	}

	public Polynome derive() {
		double[] c = new double[this.getDegre()];
		for (int i = 0; i < c.length; i++) {
			c[i] = this.get(i + 1) * (i + 1);
		}
		return new Polynome(c);
	}

	public static void main(String[] args) {
		double[] t1 = { 1.0, -2.0, 1.0, 0.0 };
		Polynome p1 = new Polynome(t1);
		System.out.println("p1 = " + p1);
		System.out.println("Degré : " + p1.getDegre());
		System.out.println("p1(1) = " + p1.evalue(1.0));
		System.out.println("p1(2) = " + p1.evalue(2.0));
		System.out.println("p1' = " + p1.derive());
		double[] t2 = { -2.0, 2.0 };
		Polynome p2 = new Polynome(t2);
		System.out.println("p2 = " + p2);
		System.out.println("p1' == p2 ? : " + (p2 == p1.derive()));
		System.out.println("p1' equals p2 ? : " + p2.equals(p1.derive()));
		double[] t3 = { -1.0, 0.0, 0.0, 3.0 };
		Polynome p3 = new Polynome(t3);
		System.out.println("p3 = " + p3);
	}
}