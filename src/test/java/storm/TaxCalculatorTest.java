package storm;

import org.junit.Test;

public class TaxCalculatorTest {

    @Test
    public void testCalculatorTest(){
        float result = (new TaxCalculator(1000, 100)).getPayableTax();
        System.out.println(result);
        TaxCalculator taxCalculator = new TaxCalculator(2000, 90);
        float f = TaxCalculator.taxRate;
        System.out.println("taxRate is: " + f);
    }
}
