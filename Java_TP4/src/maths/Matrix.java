package maths;

public class Matrix {

	private double[][] coeffs;

	public Matrix(int nbRows, int nbColumns) {
		if (nbRows > 0 && nbColumns > 0) {
			this.coeffs = new double[nbRows][nbColumns];
			for (int i = 0; i < this.coeffs.length; i++) {
				for (int j = 0; j < this.coeffs[i].length; j++) {
					this.coeffs[i][j] = 0.0;
				}
			}
		} else {
			this.coeffs = new double[0][0];
		}
	}

	public Matrix(double[][] m) {
		this(m.length, m[0].length);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				this.coeffs[i][j] = m[i][j];
			}
		}
	}

	public Matrix(Matrix m) {
		this(m.coeffs);
	}

	public int getNbRows() {
		return this.coeffs.length;
	}

	public int getNbColumns() {
		if (this.getNbRows() > 0) {
			return this.coeffs[0].length;
		} else {
			return 0;
		}
	}

	public double get(int row, int column) {
		if (row < 0 || row >= this.getNbRows() || column < 0
				|| column >= this.getNbColumns()) {
			return Double.POSITIVE_INFINITY;
		} else {
			return this.coeffs[row][column];
		}
	}

	public void set(int row, int column, double value) {
		if (row >= 0 && row < this.getNbRows() && column >= 0
				&& column < this.getNbColumns()) {
			this.coeffs[row][column] = value;
		}
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < this.getNbRows(); i++) {
			for (int j = 0; j < this.getNbColumns(); j++) {
				res = res + this.get(i, j) + "\t";
			}
			res = res + "\n";
		}
		return res;
	}

	public double sum() {
		double sum = 0.0;
		for (int i = 0; i < this.getNbRows(); i++) {
			for (int j = 0; j < this.getNbColumns(); j++) {
				sum = sum + this.get(i, j);
			}
		}
		return sum;
	}

	public boolean allPositive() {
		boolean allPositive = true;
		int i = 0, j;
		while (allPositive && i < this.getNbRows()) {
			j = 0;
			while (allPositive && j < this.getNbColumns()) {
				allPositive = this.get(i, j) > 0;
				j++;
			}
			i++;
		}
		return allPositive;
	}

	public Matrix product(Matrix m) {
		Matrix res = null;
		if (this.getNbColumns() == m.getNbRows()) {
			res = new Matrix(this.getNbRows(), m.getNbColumns());
			for (int i = 0; i < this.getNbRows(); i++) {
				for (int j = 0; j < m.getNbColumns(); j++) {
					double sum = 0.0;
					for (int k = 0; k < this.getNbColumns(); k++) {
						sum = sum + this.get(i, k) * m.get(k, j);
					}
					res.set(i, j, sum);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Matrix m1 = new Matrix(2, 3);
		m1.set(0, 0, 1.1);
		m1.set(0, 1, 1.2);
		m1.set(0, 2, -1.3);
		m1.set(1, 0, -2.1);
		m1.set(1, 1, 2.2);
		m1.set(1, 2, 2.3);
		double[][] tab = { { 1.1, 1.2, -1.3 }, { -2.1, 2.2, 2.3 } };
		Matrix m2 = new Matrix(tab);
		System.out.println("m2 =\n" + m2);
		System.out.println("Somme des valeurs de m2 : " + m2.sum());
		System.out.println("m2 ne contient que des positifs ? "
				+ m2.allPositive());
		double[][] tab3 = { { 1.0, 12.5, 20.8 }, { 2.3, 7.45, 8.1 } };
		Matrix m3 = new Matrix(tab3);
		System.out.println("\nm3 =\n" + m3);
		System.out.println("m3 ne contient que des positifs ? "
				+ m3.allPositive());
		double[][] tab4 = { { 1, 2, 0 }, { 4, 3, -1 } };
		Matrix m4 = new Matrix(tab4);
		double[][] tab5 = { { 5, 1 }, { 2, 3 }, { 3, 4 } };
		Matrix m5 = new Matrix(tab5);
		Matrix m6 = m4.product(m5);
		System.out.println("\nm4 =\n" + m4);
		System.out.println("m5 =\n" + m5);
		System.out.println("m6 = m4 x m5 =\n" + m6);
	}
}