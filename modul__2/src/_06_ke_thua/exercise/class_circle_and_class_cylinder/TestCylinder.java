package _06_ke_thua.exercise.class_circle_and_class_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1.toString());

        Cylinder cylinder = new Cylinder(5.0,"yellow",5);
        System.out.println(cylinder.toString());
    }
}
