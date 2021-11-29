package _06_ke_thua.exercise.class_circle_and_class_cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle2 = new Circle();
        System.out.println(circle2.toString());

        Circle circle = new Circle(2.5,"green");
        System.out.println(circle.toString());

        Circle circle1 = new Circle(5.0,"red");
        System.out.println(circle1.toString());
    }
}
