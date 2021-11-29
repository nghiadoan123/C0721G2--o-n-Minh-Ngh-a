package _06_ke_thua.exercise.triangle;

import _06_ke_thua.practice.he_cac_doi_tuong_hinh_hoc.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter(){
        double perimeter;
        return perimeter = this.side1+this.side2+this.side3;
    }

    public double getArea(){
        double area;
        double p;
        p = getPerimeter()/2;
        area = Math.pow(p*(p-this.side1)*(p-this.side2)*(this.side3),0.5) ;
        return area;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + this.getColor() +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}
