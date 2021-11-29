package _04_class_and_object_in_java.practice.test_class_rectange;

public class Rectange {

    double width, height;

    public Rectange() {

    }

    public Rectange(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

//    public void drawRectangle() {
//        for (int i = 1; i <= this.height; i++) {
//            for (int j = 1; j <= this.width; j++) {
//                if (i == 1 || i == this.height || j == 1 || j == this.width) {
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public void drawSolidrectangle() {
//        for (int i = 1; i <= this.height; i++) {
//            for (int j = 1; j <= this.width; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }
}
