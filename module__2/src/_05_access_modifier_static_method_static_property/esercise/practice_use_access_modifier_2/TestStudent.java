package _05_access_modifier_static_method_static_property.esercise.practice_use_access_modifier_2;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.toString());

        student.setClasses("C07");
        student.setName("Nghia");
        System.out.println(student.toString());
    }
}
