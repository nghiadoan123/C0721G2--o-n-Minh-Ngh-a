package _23_behavioral_design_pattern.practice.observer_pattern;

public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    public void update() {
        System.out.print(" " + Integer.toHexString(subject.getState()));
    }
}
