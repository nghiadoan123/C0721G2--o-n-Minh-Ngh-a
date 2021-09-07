package _04_class_and_object_in_java.exercise.fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setColor("yellow");
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        System.out.println(fan1.toString());
        System.out.println();
        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setColor("blue");
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        System.out.println(fan2.toString());
    }
}
