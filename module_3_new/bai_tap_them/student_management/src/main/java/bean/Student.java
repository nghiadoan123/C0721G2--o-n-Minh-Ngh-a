package bean;

public class Student {

    private int id;
    private String name;
    private String gender;
    private int age;
    private double average;
    private int idClass;

    public Student() {
    }

    public Student(int id, String name, String gender, int age, double average) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.average = average;
    }

    public Student(int id, String name, String gender, int age, double average, int idClass) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.average = average;
        this.idClass = idClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
}
