package _07_abstract_class_and_interface.practice.interface_compareable_for_geometry_class;

public class Circle extends Shape implements Comparable<Circle> {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public int compareTo(Circle o) {
        if (this.getRadius()>o.getRadius()){
            return 1;
        }else if (this.getRadius()<o.getRadius()){
            return -1;
        } else {
            return 0;
        }
    }
}
