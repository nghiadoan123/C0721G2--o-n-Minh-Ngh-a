package _22_structural_design_pattern.practice.social_facade_pattern;

public class LinkedIn implements SocialShare {

    private String message;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void share() {
        System.out.println("Sharing to LinkedIn: " + this.message);
    }
}
