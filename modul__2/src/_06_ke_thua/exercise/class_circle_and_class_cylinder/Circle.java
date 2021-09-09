package _06_ke_thua.exercise.class_circle_and_class_cylinder;

public class Circle {
    private double radius =0;
    private String color = "white";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double area (){
        double area;
        area = Math.PI*this.radius;
        return area;
    }

    @Override
    public String toString() {
        return " circle {" +
                "radius= " + radius +
                ", color= '" + color +
                ",area= '" + area() +'\'' +
                '}';
    }
}
