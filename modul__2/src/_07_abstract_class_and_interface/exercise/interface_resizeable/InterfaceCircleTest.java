package _07_abstract_class_and_interface.exercise.interface_resizeable;

public class InterfaceCircleTest {
    public static void main(String[] args) {
        InterfaceResizeable circle = new Circle();
        circle.resize(Math.random() * 10);
        System.out.println(circle);
    }
}
