package _06_ke_thua.exercise.class_circle_and_class_cylinder;

public class Cylinder extends Circle {
    double high=0;

    public Cylinder() {

    }

    public Cylinder(double radius, String color, double high) {
        super(radius, color);
        this.high = high;
    }

    public double volume() {
        double volume;
        volume = Math.PI * Math.pow(getRadius(),2) * high;
        return volume;
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "high= " + high +
                " volume= " + volume() +"}" +
                super.toString() +
                '}';
    }
}
