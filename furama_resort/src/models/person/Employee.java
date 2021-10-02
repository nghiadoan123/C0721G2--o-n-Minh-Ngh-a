package models.person;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private String level;
    private String position;
    private Double salary;

    public final static String INTERMEDIATE = "intermediate";
    public final static String COLLEGE = "college";
    public final static String UNIVERSITY = "university";
    public final static String AFFTERUNIVERSITY = "afferuniversity";

    public final static String RECEPTION = "reception";
    public final static String WAITERS = "waiters";
    public final static String EXPERT = "expert";
    public final static String SUPERVIOR = "supervisor";
    public final static String MANAGER = "manager";
    public final static String GENERAL = "General Manager";

    public Employee() {
    }

    public Employee(String id, String name, String dayOfBirth, String gender, int identityNumber, String phoneNumber, String email, String level, String position, Double salary) {
        super(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        return "Employee{" +
                super.toString() +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getId()+","+super.getName()+","+super.getDayOfBirth()+","+super.getGender()+","+super.getIdentityNumber()+","+super.getPhoneNumber()+","+super.getEmail()+","+level+","+position+","+salary;
    }

}
