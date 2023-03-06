/**
 * Cette classe modélise un point dans le plan.
 * 
 * @author jml
 * 
 */
public class Point {

	// Coordonnées

	// /**
	// * L'abscisse du point.
	// */
	// private double x;

	// /**
	// * L'ordonnée du point.
	// */
	// private double y;
	/**
	 * La distance du point à l'origine.
	 */
	private double rho;

	/**
	 * L'angle formé avec l'axe des abscisses.
	 */
	private double theta; // ]-pi;pi]

	// Constructeurs

	/**
	 * Construit un point à partir de son abscisse et de son ordonnée.
	 * 
	 * @param x
	 *            L'abscisse du point.
	 * @param y
	 *            L'ordonnée du point.
	 */
	public Point(double x, double y) {
		// this.x = x;
		// this.y = y;
		this.rho = Math.sqrt(x * x + y * y);
		this.theta = Math.atan2(y, x);
	}

	/**
	 * Construit le point à (0, 0) (constructeur par défaut).
	 */
	public Point() {
		this(0, 0);
	}

	// Accesseurs en lecture et en écriture

	/**
	 * @return the x
	 */
	public double getX() {
		// return x;
		return this.rho * Math.cos(this.theta);
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		// this.x = x;
		double y = this.getY();
		this.rho = Math.sqrt(x * x + y * y);
		this.theta = Math.atan2(y, x);
	}

	/**
	 * @return the y
	 */
	public double getY() {
		// return y;
		return this.rho * Math.sin(this.theta);
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		// this.y = y;
		double x = this.getX();
		this.rho = Math.sqrt(x * x + y * y);
		this.theta = Math.atan2(y, x);
	}

	/**
	 * @return the rho
	 */
	public double getRho() {
		return rho;
	}

	/**
	 * @param rho
	 *            the rho to set
	 */
	public void setRho(double rho) {
		this.rho = rho;
	}

	/**
	 * @return the theta
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * @param theta
	 *            the theta to set
	 */
	public void setTheta(double theta) {
		this.theta = Math.atan2(Math.sin(theta), Math.cos(theta));
	}

	// Services

	/**
	 * Translate le point.
	 * 
	 * @param deplacementHorizontal
	 *            La partie horizontale du vecteur de déplacement.
	 * @param deplacementVertical
	 *            La partie verticale du vecteur de déplacement.
	 */
	public void translater(double deltaX, double deltaY) {
		this.setX(this.getX() + deltaX);
		this.setY(this.getY() + deltaY);
	}

	/**
	 * Calcule la distance du point à un autre point.
	 * 
	 * @param p
	 *            Le point dont on veut calculer la distance par rapport au
	 *            point courant.
	 */
	public double distance(Point p) {
		double dX = p.getX() - this.getX();
		double dY = p.getY() - this.getY();
		return Math.sqrt((dX * dX) + (dY * dY));
	}

	/**
	 * Effectue une rotation du point autour de l'origine.
	 * 
	 * @param angle
	 *            L'angle de rotation.
	 */
	public void rotation(double angle) {
		this.setTheta(this.getTheta() + angle);
	}

	@Override
	public String toString() {
		return "(" + this.getX() + ", " + getY() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (this.getX() == p.getX() && this.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}

}
