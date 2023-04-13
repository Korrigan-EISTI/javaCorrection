package Paires;

public class TestPaires {
	public static void main (String[] args) {
		Paires<Integer, Integer> paire = new Paires<>(1, 2);
//		System.out.println(Paires.<Integer>Paires.plusGrand(paire));  
		System.out.println(Paires.<Integer> somme(paire));
		System.out.println(Paires.somme1(new Paires<Integer, Double>(22,1.7)));
	}
}
