import java.util.Scanner;

/**
 * Created by digibrose on 17/11/2014.
 */
public class FractionCalculatorTest {
    public static void main (String[] args) {

        Fraction Result = new Fraction(1, 1);

        FractionCalculator TestCalc= new FractionCalculator();
        System.out.println("checking for system errors");

        test(TestCalc.evaluate(Result, "3/4 - 1/2"), new Fraction(1, 4), "error 1");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "3/4 + 1/2 - 1/4"), new Fraction(1, 1), "error 2");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "-3/4 + 1/2"), new Fraction(-1, 4), "error 3");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "3/4 + -1/2 -3/4"), new Fraction(-1, 2), "error 4");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "3/4 * 1/2"), new Fraction(3, 8), "error 5");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "1 + 1/2"), new Fraction(3, 2), "error 7");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "1/2 + 1"), new Fraction(3, 2), "error 8");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "1/4 / 1/2"), new Fraction(1, 2), "error 9");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "3/4 - 1/2 c"), new Fraction(0, 1), "error 10");
        TestCalc.reset();
        test(TestCalc.evaluate(Result, "1/4 - 1/2 a"), new Fraction(1, 4), "error 11");
        TestCalc.reset();

        System.out.println("c for clear, a for absolute value");

        System.out.println("What would you like to calculate?");
        Scanner  In = new Scanner(System.in);
        String Input = In.nextLine();
        System.out.println(Input);
        Result = TestCalc.evaluate(Result, Input);
        TestCalc.calcintegerval();
        System.out.println(TestCalc.getintegerval() + " " + TestCalc.getintegerfrac());

        while (!Input.contains("q")) {
            System.out.println("Type more to continue calculation, type q to finish.");
            Input = In.nextLine();
            Result = TestCalc.evaluate(Result, Input);
            TestCalc.calcintegerval();
            System.out.println(TestCalc.getintegerval() + " " + TestCalc.getintegerfrac());
            }
        }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
            System.out.println(msg);
    }

    }
