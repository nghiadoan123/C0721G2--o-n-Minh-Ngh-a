package test_hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestMain {
    public static void main(String[] args) {
        Student student = new Student("nghia",25,"dn");
        Student student6 = new Student("nghia",26,"dn");
        Student student1 = new Student("nghia",26,"dn");
        Student student2 = new Student("nghia1",23,"dn");
        Student student3 = new Student("nghia2",67,"dn");
        Student student4 = new Student("nghia3",21,"dn");
        Student student5 = new Student("nghia3",20,"dn");
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student);
        students.add(student6);

        for (Student student_1: students) {
            System.out.println(student_1.toString());
        }
    }
}
