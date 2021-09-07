package _05_access_modifier_static_method_static_property.esercise.practice_use_access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){

    }
    Circle(double radius){
        this.radius = radius +5;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return 2*(Math.PI)*radius;
    }
}
