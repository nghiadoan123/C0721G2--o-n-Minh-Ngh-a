package _07_abstract_class_and_interface.exercise.interface_colorable;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        Shape shape1 = new Shape("red", false);
        System.out.println(shape1);
    }
}
