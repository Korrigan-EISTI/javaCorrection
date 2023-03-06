/**
 * Cette classe modélise un segment dans le plan par ses deux extrémités.
 * 
 * @author jml
 * 
 */
public class Segment {

	/**
	 * Les extrémités du segment.
	 */
	private Point p1;
	private Point p2;

	/**
	 * Construit un segment à partir de deux points. Les deux points
	 * représentent les extrémités du segment.
	 * 
	 * @param p1
	 * @param p2
	 */
	public Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// /**
	// * Construit un segment par recopie superficielle d'un autre segment. Les
	// * deux segments partagent les points représentant leurs extrémités.
	// *
	// * @param s
	// */
	// public Segment(Segment s) {
	// this(s.p1, s.p2);
	// }

	/**
	 * Construit un segment par recopie profonde d'un autre segment. Les deux
	 * segments ne partagent pas les points représentant leurs extrémités.
	 * 
	 * @param s
	 */
	public Segment(Segment s) {
		this(new Point(s.getP1().getX(), s.getP1().getY()), new Point(s.getP2()
				.getX(), s.getP2().getY()));
	}

	/**
	 * @return the p1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * @param p1
	 *            the p1 to set
	 */
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * @param p2
	 *            the p2 to set
	 */
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return this.getP1() + " - " + this.getP2();
	}

	public static void main(String[] args) {
		Segment s1 = new Segment(new Point(), new Point(1, 1));
		Segment s2 = new Segment(s1);
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		s1.getP2().translater(0, -1);
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
	}

}
