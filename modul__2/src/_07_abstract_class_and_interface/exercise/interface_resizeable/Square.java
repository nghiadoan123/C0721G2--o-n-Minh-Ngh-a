package _07_abstract_class_and_interface.exercise.interface_resizeable;

public class Square extends Rectangle implements InterfaceResizeable{
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
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.setLength(this.getLength()+ percent/100) ;
        this.setWidth(this.getWidth()+ percent/100) ;
    }
}
