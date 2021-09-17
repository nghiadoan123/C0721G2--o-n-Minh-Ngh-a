package _07_abstract_class_and_interface.practice.animal_class_and_interface_edible.animal;

import _07_abstract_class_and_interface.practice.animal_class_and_interface_edible.edible.Edible;
import _07_abstract_class_and_interface.practice.animal_class_and_interface_edible.fruit.Apple;
import _07_abstract_class_and_interface.practice.animal_class_and_interface_edible.fruit.Fruit;
import _07_abstract_class_and_interface.practice.animal_class_and_interface_edible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
//        Edible edible1 = new Chicken();
//        System.out.println(edible1.howToeat());
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Edible) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToeat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToeat());
        }
    }
}
