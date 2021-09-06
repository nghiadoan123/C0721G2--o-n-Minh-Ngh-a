package _04_class_and_object_in_java.exercise.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed > 0 && speed <= 3) {
            this.speed = speed;
        } else {
            System.out.println("enter speed form 1 to 3");
        }
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    Fan() {

    }

    public String toString() {
        if (isOn()) {
            return "fan is on \n" + "speed is: " + this.getSpeed() + "\n" + "color is: " + this.getColor() + "\n" + "radius is:" + this.getRadius();
        } else {
            return "fan is off \n" + "color is: " + this.getColor() + "\n" + "radius is: " + this.getRadius();
        }
    }
}
