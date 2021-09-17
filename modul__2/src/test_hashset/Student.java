package test_hashset;

import java.util.Objects;

public class Student  {
    String name;
    int age;
    String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student){
            Student student = (Student) o;
            return Objects.equals(this.name, student.name);
                   //&&age == student.age;
//                && Objects.equals(address, student.address);
        }
        return false;
    }

    //    @Override
//    public int hashCode() {
//        return 1;
//    }

//    @Override
//    public int compareTo(Student o) {
//        if (this.getName()==o.name){
//            if (this.getAge()-o.age==0){
//                return this.getAddress().compareTo(o.address);
//            }else {
//                return this.getAge()-o.age;
//            }
//        }else {
//            return this.getName().compareTo(o.name);
//        }
//
//    }
}
