package _15_exception_and_debug.exeicise.illegal_triangle_exception;

public class IllegalTriangleException extends Exception {
    public void negativeException(){
        System.out.println("sô nhập vào là số âm");
    }

    public void checkSumException(){
        System.out.println("3 canh nhập vào không hợp lệ");
    }
}
