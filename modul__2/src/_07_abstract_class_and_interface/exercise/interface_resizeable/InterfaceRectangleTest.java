package _07_abstract_class_and_interface.exercise.interface_resizeable;

public class InterfaceRectangleTest {
    public static void main(String[] args) {
        InterfaceResizeable rectangle = new Rectangle(3,25,"red",true);
        rectangle.resize(Math.random() * 10);
        System.out.println(rectangle);

        InterfaceResizeable rectangle1 = new Rectangle();
        rectangle1.resize(Math.random()*10);
        System.out.println(rectangle1);
    }
}
