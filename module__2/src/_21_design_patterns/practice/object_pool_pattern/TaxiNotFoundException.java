package _21_design_patterns.practice.object_pool_pattern;

public class TaxiNotFoundException extends RuntimeException{
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}
