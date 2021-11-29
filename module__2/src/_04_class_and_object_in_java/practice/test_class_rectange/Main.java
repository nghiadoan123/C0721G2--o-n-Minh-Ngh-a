package _04_class_and_object_in_java.practice.test_class_rectange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        Rectange rectangle = new Rectange(width, height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
//        System.out.println("draw rectangle");
//        rectangle.drawRectangle();
//        System.out.println("draw solid rectangle");
//        rectangle.drawSolidrectangle();
    }
}
