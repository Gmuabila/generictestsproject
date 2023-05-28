package stormThree;

public class SnowStormBackup {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;
    private double amountOfSnow;

    public SnowStormBackup(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }

    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }
}
