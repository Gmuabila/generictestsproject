package storm;

public class RainStorm extends Storm {
    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        super(eyeRadius, eyePositionX, eyePositionY);
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }

    @Override
    public String toString() {
        return "RainStorm{" +
                "eyeRadius=" + eyeRadius +
                ", eyePositionX=" + eyePositionX +
                ", eyePositionY=" + eyePositionY +
                '}';
    }
}

