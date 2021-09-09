package _07_abstract_class_and_interface.exercise.interface_colorable;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        Square square1 = new Square(5,"black",false);
        System.out.println(square1);
    }
}
