package _07_abstract_class_and_interface.exercise.interface_resizeable;

import _07_abstract_class_and_interface.exercise.interface_colorable.Circle;
import _07_abstract_class_and_interface.exercise.interface_colorable.Rectangle;
import _07_abstract_class_and_interface.exercise.interface_colorable.Shape;
import _07_abstract_class_and_interface.exercise.interface_colorable.Square;

public class InterfaceResizeableTest {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[3];
        shapeList[0] = new Circle(5, "blue", true);
        shapeList[1] = new Rectangle(4, 25, "red", false);
        shapeList[2] = new Square(4, "green", true);
        // c1
//        for (int i = 0; i <shapeList.length ; i++) {
//            if (shapeList[i] instanceof Circle){
//                ((Circle)shapeList[i]).resize(Math.random()*10);
//                System.out.println(((Circle)shapeList[i]).toString());
//            }else if (shapeList[i] instanceof Rectangle){
//                ((Rectangle)shapeList[i]).resize(Math.random()*10);
//                System.out.println(((Rectangle)shapeList[i]).toString());
//            } else {
//                ((Square)shapeList[i]).resize(Math.random()*10);
//                System.out.println(((Square)shapeList[i]).toString());
//            }
//        }
        // c2
        for (int i = 0; i < shapeList.length; i++) {
            // System.out.println(shapeList[i]instanceof InterfaceResizeable);
            if (shapeList[i] instanceof InterfaceResizeable) {
                ((InterfaceResizeable) shapeList[i]).resize(Math.random() * 10);
            }
            System.out.println(shapeList[i]);
        }
    }
}

