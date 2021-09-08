package _06_ke_thua.exercise.class_point_and_moveable_point;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }

    public String getXY(){
        float [] arr = new float[2];
        arr[0] = this.x;
        arr[1] = this.y;
        return Arrays.toString(arr);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", get x,y position = " + getXY() +
                '}';
    }
}
