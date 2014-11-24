/**
 * Created by digibrose on 17/11/2014.
 */
public class FractionCalculator {

    private Fraction Result;
    private int function;
    private Fraction Other;
    private int integerval;
    private Fraction integerfrac;

    // constructor method for FractionCalculator

    public FractionCalculator() {

        Result = new Fraction(0,1);
        Other = new Fraction(0,1);
        integerfrac = new Fraction(0, 1);
    }

    // getter methods to return private values

    public int getintegerval(){
        return integerval;
    }

    public Fraction getintegerfrac(){
        return integerfrac;
    }

    //reset method for fractioncalc
    public void reset() {
        Result.setNumerator(0);
        Result.setDenominator(1);
        Other.setNumerator(0);
        Other.setDenominator(1);
        integerval = 0;
        integerfrac.setNumerator(0);
        integerfrac.setDenominator(1);
    }

    //method to check whether the string indicates a method should be negative
    private Fraction checkneg(Fraction fraction, boolean neg1, boolean neg2) {
        if (neg1 == true && neg2 == true ) {
            return fraction;
        }
        if (neg1 == true || neg2 == true )  {
            return fraction.negate();
        }
        return fraction;
    }

    //method to set other for the different functions
    private void setOther(int num, int denom, boolean neg1, boolean neg2) {
        Other.setNumerator(num);
        Other.setDenominator(denom);
        Other = checkneg(Other, neg1, neg2);
    }

    //method to work out values to be printed
    public void calcintegerval (){
        integerval = Result.getNumerator()/Result.getDenominator();
        integerfrac = Result.subtract(new Fraction(integerval, 1));

    }

    //The evaluate method that takes the string and works out what to do
    public Fraction evaluate(Fraction fraction, String inputString) {
    int ln = inputString.length();
    int i = 0;
    int start = 0;
    int end = 0;
    int num = 0;
    int denom = 0;
    boolean neg1 = false;
    boolean neg2 = false;
    boolean wholenum = false;

    while (i < ln) {
        //what to do if a number is found in string
        if (Character.isDigit(inputString.charAt(i))) {
            start = i;
            end = i;
            //work out the length of number
            while (Character.isDigit(inputString.charAt(end))) {
                end++;
                if (end == ln) {
                    wholenum = true;
                    break;
                }
            }
            //check if whole number
            if (end != ln) {
                if (Character.isSpaceChar(inputString.charAt(end))) {
                    wholenum = true;
                }
            }
            //check if negative
            if (start != 0) {
                if (inputString.charAt(start - 1) == '-') {
                    neg1 = true;
                }
            }
            num = Integer.parseInt(inputString.substring(start, end));
            //if not whole number find denominator
            if (wholenum == false) {
                start = end + 1  ;
                end = end + 1;
                if (inputString.charAt(start) == '-') {
                    start++;
                    end++;
                    neg2 = true;
                }
                while (Character.isDigit(inputString.charAt(end))) {
                    end++;
                    if (end == ln) {
                        break;
                    }
                }
                denom = Integer.parseInt(inputString.substring(start, end));
            }
            else {
                denom = 1;
                wholenum = false;
            }
            //Set initial Result value if no function
            if (function == 0) {
                Result.setNumerator(num);
                Result.setDenominator(denom);
                Result = checkneg(Result, neg1, neg2);
                neg1 = false;
                neg2 = false;
            }
            //Set value to be added and carry out function
            else if ( function == 1 ) {
                setOther(num, denom, neg1, neg2);
                Result = Result.add(Other);
                neg1 = false;
                neg2 = false;
            }
            else if ( function == 2 ) {
                setOther(num, denom, neg1, neg2);
                Result = Result.subtract(Other);
                neg1 = false;
                neg2 = false;
            }
            else if ( function == 3 ) {
                setOther(num, denom, neg1, neg2);
                Result = Result.multiply(Other);
                neg1 = false;
                neg2 = false;
            }
            else if ( function == 4 ) {
                setOther(num, denom, neg1, neg2);
                Result = Result.divide(Other);
                neg1 = false;
                neg2 = false;
            }
            i = end;
        }
        //Set function value as string is parsed
        else if (inputString.charAt(i) == '+' ) {
            function = 1;
        }
        else if ((inputString.charAt(i) == '-') && (Character.isSpaceChar(inputString.charAt(i + 1)))  ) {
            function = 2;
        }
        else if ((inputString.charAt(i) == '*')) {
            function = 3;
        }
        else if ((inputString.charAt(i) == '/')) {
            function = 4;
        }
        else if ((inputString.charAt(i) == 'a') || (inputString.charAt(i) == 'A')) {
            Result = Result.absValue();
            neg1 = false;
            neg2 =  false;
            //jump over rest of possible abs input
            if (i + 2 < ln ) {
                if (inputString.contains("abs")) {
                    i = i + 2;
                }
            }
        }
        else if ((inputString.charAt(i) == 'c') || (inputString.charAt(i) == 'C')) {
            reset();
            function = 0;
            //jump over rest of clear possible input
            if (i + 4 < ln ) {
                if (inputString.contains("clear")) {
                    i = i + 4;
                }
            }
        }
        //jump over if other valid character
        else if (Character.isSpaceChar(inputString.charAt(i)) || ((inputString.charAt(i) == '-') && (!Character.isSpaceChar(inputString.charAt(i + 1)))) || inputString.charAt(i) == 'q') {
        }
        //return error if anything else
        else {
            reset();
            function = 0;
            System.out.println("Error in input");
            return Result;
        }
        i++;
    }
    function = 0;
    return Result;
    }
}
