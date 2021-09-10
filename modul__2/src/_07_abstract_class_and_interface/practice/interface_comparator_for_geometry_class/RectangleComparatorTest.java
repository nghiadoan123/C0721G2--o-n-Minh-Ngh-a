package _07_abstract_class_and_interface.practice.interface_comparator_for_geometry_class;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle();
        rectangles[1] = new Rectangle(7.5,9);
        rectangles[2] = new Rectangle(5.5,9,"white",true);

        System.out.println("Pre-sorted:");
        for (Rectangle rectangle: rectangles) {
            System.out.println(rectangle);
        }

        Comparator<Rectangle> rectangle = new RectangleComparator();
        Arrays.sort(rectangles,rectangle);

        System.out.println("After-sorted:");
        for (Rectangle rec : rectangles) {
            System.out.println(rec);
        }
    }
}
