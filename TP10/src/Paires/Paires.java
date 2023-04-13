package Paires;

import java.util.*;

public class Paires <X extends Comparable<X>,Y extends Comparable<Y>> implements Comparable<Paires<X,Y>>, Cloneable{
	private X first;
	private Y second;
	
	public Paires(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	public X getFirst() {
		return this.first;
	}
	public void setFirst(X first) {
		this.first = first;
	}
	public Y getSecond() {
		return this.second;
	}
	public void setSecond(Y second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paires<?,?> && this.getFirst().equals(((Paires<?,?>) obj).getFirst()) && this.getSecond().equals(((Paires<?,?>) obj).getSecond()));
	}

	@Override
	public String toString() {
		return "(" + this.getFirst() + "," + this.getSecond() + ")";
	}
	
	@Override
	public Object clone() {
		return new Paires<X,Y> (this.getFirst(), this.getSecond());
	}
	
	public static <A extends Comparable<A>>A plusGrand (Paires <A,A> p){
		return (p.getFirst().compareTo(p.getSecond()) > 0) ? p.getFirst() : p.getSecond();
	}
	
	@Override
	public int compareTo(Paires<X, Y> o) {
		int elmt = this.getFirst().compareTo(o.getFirst());
		if (elmt == 0) {
			elmt = this.getSecond().compareTo(o.getSecond());
		}
		return elmt;
	}
	
	public static <A extends Number & Comparable<A>>double somme(Paires<A,A> p) {
		return p.getFirst().doubleValue() + p.getSecond().doubleValue();
	}
	
	public static double somme1 (Paires <? extends Number, ? extends Number> p) {
		return p.getFirst().doubleValue() + p.getSecond().doubleValue();
	}
	
	public class Comparateur1 implements Comparator<Paires<X,Y>>{
		@Override
		public int compare(Paires<X, Y> o1, Paires<X, Y> o2) {
			X x1 = o1.getFirst();
			X x2 = o2.getFirst();
			return x1.compareTo(x2);
		}
	}
	
	public class Comparateur2 implements Comparator<Paires<X,Y>>{
		@Override
		public int compare(Paires<X, Y> o1, Paires<X, Y> o2) {
			Y x1 = o1.getSecond();
			Y x2 = o2.getSecond();
			return x1.compareTo(x2);
		}
	}
	
	public class Comparateur3 implements Comparator<Paires<? extends Number,? extends Number>>{
		@Override
		public int compare(Paires<? extends Number, ? extends Number> o1, Paires<? extends Number, ? extends Number> o2) {
			Double s1 = Double.valueOf(somme1(o1));
			Double s2 = Double.valueOf(somme1(o2));
			return s1.compareTo(s2);
		}
	}
}
