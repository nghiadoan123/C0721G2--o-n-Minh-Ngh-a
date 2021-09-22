package _15_exception_and_debug.exeicise.illegal_triangle_exception;

public class TestTriangleException {
    public static void main(String[] args) {
        TriangleEdge triangleEdge = new TriangleEdge();
        try {
            triangleEdge.triangleEdge();
        } catch (IllegalTriangleException e) {
            System.err.println(e.getError());
        }
    }
}
