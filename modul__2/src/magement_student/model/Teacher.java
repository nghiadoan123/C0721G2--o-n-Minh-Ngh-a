package magement_student.model;

public class Teacher extends Employe {
    public Teacher() {

    }

    public Teacher(double salary) {
        super(salary);
    }

    public Teacher(String name, int age, String address, double salary) {
        super(name, age, address, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}';
    }
}
