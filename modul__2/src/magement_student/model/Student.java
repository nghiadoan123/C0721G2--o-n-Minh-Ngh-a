package magement_student.model;

public class Student extends Person {
    private String subject;

    public Student() {
    }

    public Student(String name, int age, String address) {
        super(name, age, address);
    }

    public Student(String name, int age, String address, String subject) {
        super(name, age, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
