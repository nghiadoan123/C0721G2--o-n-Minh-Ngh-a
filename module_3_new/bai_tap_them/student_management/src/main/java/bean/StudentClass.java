package bean;

public class StudentClass {
    private  int idClass;
    private String className;

    public StudentClass() {
    }

    public StudentClass(int idClass, String className) {
        this.idClass = idClass;
        this.className = className;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
