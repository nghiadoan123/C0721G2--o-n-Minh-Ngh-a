package _04_class_and_object_in_java.exercise.test_quadratic_equation;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number a:");
        double a = sc.nextDouble();
        System.out.println("enter number b:");
        double b = sc.nextDouble();
        System.out.println("enter number c:");
        double c = sc.nextDouble();
        QuadraticEquation quaDraticequation = new QuadraticEquation(a,b,c);
        System.out.println(quaDraticequation.display());
    }
}
