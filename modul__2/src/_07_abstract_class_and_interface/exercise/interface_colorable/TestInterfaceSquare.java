package _07_abstract_class_and_interface.exercise.interface_colorable;

public class TestInterfaceSquare {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[5];
        shapeList[0] = new Circle(5, "pink", true);
        shapeList[1] = new Rectangle(5, 8, "green", false);
        shapeList[2] = new Rectangle();
        shapeList[3] = new Square(4, "white", true);
        shapeList[4] = new Square();

        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] instanceof Circle) {
                System.out.println(((Circle) shapeList[i]).toString());
            } else if (shapeList[i] instanceof Rectangle && shapeList[i] instanceof Square) {
                ((Square) shapeList[i]).howTocolor();
                System.out.println(((Square) shapeList[i]).toString());
            } else if (shapeList[i] instanceof Rectangle){
                System.out.println(((Rectangle) shapeList[i]).toString());
            }
        }
    }
}
