/**
 * Cette classe permet de tester la classe Point.
 * 
 * @author jml
 * 
 */
public class TestPoint {

	public static void main(String[] args) {
		Point p1 = new Point(1.1, 2.0);
		Point p2 = new Point(2.2, 1.7);
		Point p3 = p1;
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		System.out.println("p3 = " + p3);
		System.out.println("Distance entre p1 et p2 : " + p1.distance(p2));
		p2.translater(-1.1, 0.3);
		System.out.println("p2 = " + p2);
		System.out.println("p1 equals p2 : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));
		System.out.println("p1 equals p3 : " + p1.equals(p3));
		System.out.println("p1 == p3 : " + (p1 == p3));
		p3.setY(3.0);
		System.out.println("p1 = " + p1);
		System.out.println("p3 = " + p3);

		Point p4 = new Point(1, 0);
		System.out.println("p4 = " + p4);
		p4.rotation(Math.PI / 2);
		System.out.println("p4 = " + p4);
	}

}
