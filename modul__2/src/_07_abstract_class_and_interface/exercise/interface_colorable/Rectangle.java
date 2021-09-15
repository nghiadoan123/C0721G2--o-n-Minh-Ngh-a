package _07_abstract_class_and_interface.exercise.interface_colorable;

import _07_abstract_class_and_interface.exercise.interface_resizeable.InterfaceResizeable;

public class Rectangle extends Shape  {
    protected double width = 1.0;
    protected double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + this.getWidth()
                + " and length="
                + this.getLength()
                + " area="
                + this.getArea();
    }

//    @Override
//    public void resize(double percent) {
//        this.length += percent/100;
//        this.width += percent/100;
//    }
}
