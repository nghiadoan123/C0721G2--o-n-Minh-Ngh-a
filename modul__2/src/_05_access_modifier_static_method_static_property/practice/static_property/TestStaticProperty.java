package _05_access_modifier_static_method_static_property.practice.static_property;

import _05_access_modifier_static_method_static_property.practice.static_property.Car;

public class TestStaticProperty {
    public static void main(String[] args) {

        Car car1 = new Car("Mazda 3", "Skyactiv 3");

        System.out.println(Car.numberOfCars);

        Car car2 = new Car("Mazda 6", "Skyactiv 6");

        System.out.println(Car.numberOfCars);

    }

}
