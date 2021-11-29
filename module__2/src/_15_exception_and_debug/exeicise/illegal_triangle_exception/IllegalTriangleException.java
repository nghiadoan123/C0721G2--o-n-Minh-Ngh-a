package _15_exception_and_debug.exeicise.illegal_triangle_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    //private String error;

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
    //    public IllegalTriangleException(String error) {
//        this.error = error;
//    }
//
//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }

}

