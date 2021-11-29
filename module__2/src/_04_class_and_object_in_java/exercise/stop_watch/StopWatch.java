package _04_class_and_object_in_java.exercise.stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedtime() {
        long elapsedTime;
        elapsedTime = this.endTime - this.startTime;
        return elapsedTime;
    }
}
