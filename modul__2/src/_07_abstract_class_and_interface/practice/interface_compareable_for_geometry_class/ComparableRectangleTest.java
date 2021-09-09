package _07_abstract_class_and_interface.practice.interface_compareable_for_geometry_class;

import java.util.Arrays;

public class ComparableRectangleTest {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles = new ComparableRectangle[3];
        rectangles[0] = new ComparableRectangle(3,5);
        rectangles[1] = new ComparableRectangle();
        rectangles[2] = new ComparableRectangle(6,9,"red",true);

        System.out.println("Pre-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Arrays.sort(rectangles);

        System.out.println("After-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

    }
}
