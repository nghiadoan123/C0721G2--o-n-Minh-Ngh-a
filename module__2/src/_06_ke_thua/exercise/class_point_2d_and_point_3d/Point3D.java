package _06_ke_thua.exercise.class_point_2d_and_point_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

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
        super.setXY(x,y);
        this.z = z;
    }
    public float[] getXYZ(){
        float [] arr = new float[3];
        arr[0] = getX();
        arr[1] = getY();
        arr[2] = getZ();
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                ", x=" + getX() +
                ", y=" + getY() +
                "z=" + z +
                ", get x,y,z position = " + Arrays.toString(getXYZ()) +
                "with Point 2D"+super.toString()+
                '}';
    }
}
