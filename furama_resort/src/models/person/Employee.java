package models.person;

import models.person.Person;

public class Employee extends Person {
    private String position;
    private Double salary;

    public Employee() {
    }

    public Employee(int id, String name, String dayOfBirth, String gender, int identityNumber, String phoneNumber, String email, String position, Double salary) {
        super(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
