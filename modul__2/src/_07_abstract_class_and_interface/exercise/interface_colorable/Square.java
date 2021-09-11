package _07_abstract_class_and_interface.exercise.interface_colorable;

public class Square extends Rectangle implements InterfaceColorable {
    public Square() {
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public double getArea() {
        return super.length * super.width;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + this.getSide()
                + " Area="
                + this.getArea();

    }

    @Override
    public void howTocolor() {
        System.out.print(" Color all four sides \n");
    }
}
