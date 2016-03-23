package algs4;

import util.Numerical;
import util.StdOut;

public class Rational {
	
	private final long numerator;
	private final long denominator;
	
	public Rational(long numerator, long denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public long getNumerator() {
		return numerator;
	}


	public long getDenominator() {
		return denominator;
	}
	
	Rational plus(Rational b){
		long d = this.denominator * b.getDenominator();
		long n = this.numerator * b.getDenominator() + b.getNumerator() * this.denominator;
		long gcd;
		if((gcd = Numerical.gcd(d, n)) > 1){
			d /= gcd;
			n /= gcd;
		}
		return new Rational(n, d);
	}
	
	Rational minus(Rational b){
		long d = this.denominator * b.getDenominator();
		long n = this.numerator * b.getDenominator() - b.getNumerator() * this.denominator;
		long gcd;
		if((gcd = Numerical.gcd(d, n)) > 1){
			d /= gcd;
			n /= gcd;
		}
		return new Rational(n, d);
	}
	
	Rational times(Rational b){
		long d = this.denominator * b.getDenominator();
		long n = this.numerator * b.getNumerator();
		long gcd;
		if((gcd = Numerical.gcd(d, n)) > 1){
			d /= gcd;
			n /= gcd;
		}
		return new Rational(n, d);
	}
	
	Rational divides(Rational b){
		long d = this.denominator * b.getNumerator();
		long n = this.numerator * b.getDenominator();
		long gcd;
		if((gcd = Numerical.gcd(d, n)) > 1){
			d /= gcd;
			n /= gcd;
		}
		return new Rational(n, d);
	}
	
	boolean equals(Rational that){
		Rational result = this.minus(that);
		if(result.getNumerator() == 0)
			return true;
		else
			return false;
	}
		
	@Override
	public String toString() {
		return "Rational : " + this.numerator + "/" + this.denominator;
	}

	public static void main(String[] args) {
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(4, 5);
		
		StdOut.printf("3/4 + 4/5 = %s \n",r1.plus(r2).toString());
		StdOut.printf("3/4 - 4/5 = %s \n",r1.minus(r2).toString());
		StdOut.printf("3/4 * 4/5 = %s \n",r1.times(r2).toString());
		StdOut.printf("3/4 / 4/5 = %s \n",r1.divides(r2).toString());
		StdOut.printf("3/4 = 4/5 = ? %s \n",r1.equals(r2));
	}

}
