package _06_ke_thua.exercise.class_point_2d_and_point_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String getXYZ(){
        float [] arr = new float[3];
        arr[0] = this.x;
        arr[1] = this.y;
        arr[2] = this.z;
        return Arrays.toString(arr);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                ", x=" + x +
                ", y=" + y +
                "z=" + z +
                ", get x,y,z position = " + getXYZ() +
                "with Point 2D"+super.toString()+
                '}';
    }
}
