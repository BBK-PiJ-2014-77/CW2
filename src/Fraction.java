/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd );
    }

    @Override
    public String toString() {
        if (Math.abs(this.getDenominator()) == 1 ) {
            return "" + this.getNumerator() * this.getDenominator() ;
        }
        else {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction other) {

        int denom1 = this.denominator * other.denominator;
        int thisnum = this.numerator * other.denominator;
        int othernum = other.numerator * this.denominator;


        int newnum = thisnum + othernum;

        int gcm = this.myGcd(newnum, denom1);

        Fraction Answer = new Fraction(newnum/gcm, denom1/gcm);
        return Answer;
    }

    public Fraction subtract(Fraction other) {

        int denom1 = this.denominator * other.denominator;
        int thisnum = this.numerator * other.denominator;
        int othernum = other.numerator * this.denominator;


        int newnum = thisnum - othernum;

        int gcm = this.myGcd(newnum, denom1);

        Fraction Answer = new Fraction(newnum/gcm, denom1/gcm);
        return Answer;
    }

    public Fraction divide(Fraction other) {

    //flip the new fraction then treat as multiply

        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        int gcm  = this.myGcd(num, denom);
        return new Fraction(num/gcm, denom/gcm);

    }

    public Fraction absValue() {

        int num = this.getNumerator();
        int denom = Math.abs(this.getDenominator());
        return new Fraction(num,denom);


    }

    public Fraction negate() {

        int num = this.getNumerator() * -1 ;
        return new Fraction(num, this.getDenominator());

    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
//      ok euclides equation is better!!
//    private Fraction normalize(Fraction Input) {
//        int num = Input.numerator;
//        int den = Input.denominator;
//
//        Fraction NormalFrac = new Fraction(num, den);
//
//        for (int i=numerator; i > 1; i--)
//        if (NormalFrac.denominator % i != 0 && NormalFrac.numerator % i != 0) {
//            NormalFrac.denominator = NormalFrac.denominator/i;
//            NormalFrac.numerator =  NormalFrac.numerator/i;
//            NormalFrac = normalize(NormalFrac);
//        }
//        return NormalFrac;
//    }
}
