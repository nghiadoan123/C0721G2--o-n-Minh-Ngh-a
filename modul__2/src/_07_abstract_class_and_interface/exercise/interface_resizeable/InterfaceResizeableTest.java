package _07_abstract_class_and_interface.exercise.interface_resizeable;

public class InterfaceResizeableTest {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[3];
        shapeList[0] = new Circle(5,"blue",true);
        shapeList[1] = new Rectangle(4,25,"red",false);
        shapeList[2] = new Square(4,"green",true);

        for (int i = 0; i <shapeList.length ; i++) {
            if (shapeList[i] instanceof Circle){
                ((Circle)shapeList[i]).resize(Math.random()*10);
                System.out.println(((Circle)shapeList[i]).toString());
            }else if (shapeList[i] instanceof Rectangle){
                ((Rectangle)shapeList[i]).resize(Math.random()*10);
                System.out.println(((Rectangle)shapeList[i]).toString());
            } else {
                ((Square)shapeList[i]).resize(Math.random()*10);
                System.out.println(((Square)shapeList[i]).toString());
            }
        }
    }
}

