package cert.java.innerclass;

import java.math.BigDecimal;

public class Test {
    public static StringBuilder outerString = new StringBuilder("Hola Mundos!");
    public static void main(String[] args) {
        new Test().testLocalClass(outerString, 2, 0.05);
    }

    public void testLocalClass(StringBuilder parameter, final int intParam, double doubleParam){
        class LocalInnerClass{
            StringBuilder myLocalParam;
            LocalInnerClass(){
                myLocalParam = parameter;
            }

            private BigDecimal findRate(){
                return new BigDecimal(doubleParam);
            }

            BigDecimal calculateTax(){
                return new BigDecimal(intParam).multiply(this.findRate());
            }
        }
        LocalInnerClass innerClass = new LocalInnerClass();
        BigDecimal tax = innerClass.calculateTax();
        System.out.println(tax.toPlainString());
        System.out.println(innerClass.myLocalParam);
    }
}
