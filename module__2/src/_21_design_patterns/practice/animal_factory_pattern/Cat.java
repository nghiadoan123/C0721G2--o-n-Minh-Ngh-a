package _21_design_patterns.practice.animal_factory_pattern;

public class Cat extends Animal{
    @Override
    public String makeSound() {
        return "Meow";
    }
}
