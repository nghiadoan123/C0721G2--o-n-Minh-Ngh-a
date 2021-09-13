package _07_abstract_class_and_interface.exercise.interface_colorable;

public class Square extends Rectangle  {
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

//    @Override
//    public void setWidth(double width) {
//        super.setWidth(width);
//    }
//
//    @Override
//    public void setLength(double length) {
//        super.setLength(length);
//    }

    @Override
    public String toString() {
        return "A Square with side="
                + this.getSide()
                + " Area="
                + this.getArea();

    }
    // ko cần override vì lớp cha đã override rồi nên khi dùng sẽ dùng của lớp cha
//    @Override
//    public void resize(double percent) {
//        this.width = percent/100;
//        this.length = percent/100;
//    }

    @Override
    public void howTocolor() {
        System.out.print(" Color all four sides \n");
    }
}
