package _06_ke_thua.exercise.class_point_and_moveable_point;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint.toString());

        MoveablePoint moveablePoint1 = new MoveablePoint(35f,45f,2f,5f);
        System.out.println(moveablePoint1.toString());
    }
}
