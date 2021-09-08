package _05_access_modifier_static_method_static_property.esercise.practice_use_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        System.out.println(circle.toString());

        Circle circle1 = new Circle(20);
        System.out.println(circle1.getRadius());
        System.out.println(circle1.getArea());
        System.out.println(circle1.toString());
    }
}
