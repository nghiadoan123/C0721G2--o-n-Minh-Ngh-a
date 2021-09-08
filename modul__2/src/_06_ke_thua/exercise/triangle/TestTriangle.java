package _06_ke_thua.exercise.triangle;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.setColor("blue");
        System.out.println(triangle.toString());

        Triangle triangle1 = new Triangle(3,5,8);
        triangle1.setColor("green");
        System.out.println(triangle1.toString());
    }
}
