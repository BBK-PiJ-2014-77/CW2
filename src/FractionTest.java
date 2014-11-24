import com.sun.org.apache.xpath.internal.operations.Div;

/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, -2),"error test 5");



        // extend with extra tests

        // test add
    Fraction Add1 = new Fraction(1, 2);
    Fraction Add2 = new Fraction(1, 4);

    test(Add1.add(Add2), new Fraction(3, 4), "error test 6" );

        //test subtract

        Fraction Sub1 = new Fraction(3, 4);
        Fraction Sub2 = new Fraction(1, 4);

        test(Sub1.subtract(Sub2), new Fraction(1, 2), "error test 7" );


        // test divide
        Fraction Div1 = new Fraction(2, 6);
        Fraction Div2 = new Fraction(1, 2);

        test(Div1.divide(Div2), new Fraction(2, 3), "error test 8");

        // test absValue
        Fraction Abs1 = new Fraction(-3,8);
        Fraction Abs2 = new Fraction(3, -8);
        Fraction Abs3 = new Fraction(3, 8);

        test(Abs1.absValue(), new Fraction(3, 8), "error test 9");
        test(Abs2.absValue(), new Fraction(3, 8), "error test 10");
        test(Abs3.absValue(), new Fraction(3, 8), "error test 11");

        // test negate

        Fraction neg1 = new Fraction(3, 8);

        test(neg1.negate(), new Fraction(-3, 8), "error test 12");

        // test non fraction print

        Fraction num = new Fraction(2, 1);
        Fraction num2 = new Fraction(-4, 2);
        System.out.println(num);
        System.out.println(num2);



    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }


}
