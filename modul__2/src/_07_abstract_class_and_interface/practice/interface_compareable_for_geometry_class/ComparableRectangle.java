package _07_abstract_class_and_interface.practice.interface_compareable_for_geometry_class;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {
    public ComparableRectangle() {

    }

    public ComparableRectangle(double width, double length) {
        super(width, length);
    }

    public ComparableRectangle(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }

    @Override
    public int compareTo(ComparableRectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
