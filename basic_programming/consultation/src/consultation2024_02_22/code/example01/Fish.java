package consultation2024_02_22.code.example01;

public class Fish extends Animal {
    protected double length;
    protected String scaleColor;

    public Fish(String name, int age, double length, String scaleColor) {
        super(name, age);
        this.length = length;
        this.scaleColor = scaleColor;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }
}
