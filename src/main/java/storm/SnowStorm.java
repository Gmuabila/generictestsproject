package storm;

public class SnowStorm extends Storm{
    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        super(eyeRadius, eyePositionX, eyePositionY);
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }

    @Override
    public String toString() {
        return "SnowStorm{" +
                "eyeRadius=" + eyeRadius +
                ", eyePositionX=" + eyePositionX +
                ", eyePositionY=" + eyePositionY +
                ", amountOfSnow=" + amountOfSnow +
                '}';
    }
}
