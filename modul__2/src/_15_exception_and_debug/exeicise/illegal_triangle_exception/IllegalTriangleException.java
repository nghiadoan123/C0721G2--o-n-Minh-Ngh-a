package _15_exception_and_debug.exeicise.illegal_triangle_exception;

public class IllegalTriangleException extends Exception {
    private String err;

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String err) {
        this.err = err;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }


}

