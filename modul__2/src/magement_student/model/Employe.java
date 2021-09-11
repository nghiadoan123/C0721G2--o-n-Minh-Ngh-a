package magement_student.model;

public class Employe extends Person {
    double salary;

    public Employe() {

    }

    public Employe(double salary) {
        this.salary = salary;
    }

    public Employe(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "salary=" + salary +
                '}';
    }
}
