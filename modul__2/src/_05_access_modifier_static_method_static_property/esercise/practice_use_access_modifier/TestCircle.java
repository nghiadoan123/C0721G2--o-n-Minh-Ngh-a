package _05_access_modifier_static_method_static_property.esercise.practice_use_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }
}
