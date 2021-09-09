package _07_abstract_class_and_interface.exercise.interface_resizeable;

public class InterfaceSquareTest {
    public static void main(String[] args) {
        InterfaceResizeable square = new Square();
        square.resize(Math.random()*10);
        System.out.println(square);

        InterfaceResizeable square1 = new Square(5,"red",true);
        square1.resize(Math.random()*10);
        System.out.println(square1);
    }
}
