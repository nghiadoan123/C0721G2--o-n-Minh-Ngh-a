package _07_abstract_class_and_interface.practice.interface_compareable_for_geometry_class;

import java.util.Arrays;

public class ComparableRectangleTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(3,5);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(6,9,"red",true);

        System.out.println("Pre-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Arrays.sort(rectangles);

        System.out.println("After-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

    }
}
