package storm;

public class TaxCalculator {
    public static float taxRate = 10;
    public float grossIncome;
    public float deduction;
    /**
     * @param grossIncome The gross income.
     * @param deduction The total that is deductible before tax calculation.
     */
    public TaxCalculator(float grossIncome, float deduction) {
        this.grossIncome = grossIncome;
        this.deduction = deduction;
    }
    /**
     * @return the payable tax after deducting deductible total from gross income.
     */
    public float getPayableTax() {
        return (TaxCalculator.taxRate / 100) * (this.grossIncome - this.deduction);
    }

}
