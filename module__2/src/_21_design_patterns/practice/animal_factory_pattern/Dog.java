package _21_design_patterns.practice.animal_factory_pattern;

public class Dog extends Animal{
    @Override
    public String makeSound() {
        return "Woof";
    }
}
