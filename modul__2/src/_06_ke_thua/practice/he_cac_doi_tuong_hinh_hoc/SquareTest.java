package _06_ke_thua.practice.he_cac_doi_tuong_hinh_hoc;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        square.setWidth(2);
        System.out.println(square);

        Square square1 = new Square(2.3);
        System.out.println(square1);

        Square square2 = new Square(5.8, "yellow", true);
        square2.setSide(65);
        System.out.println(square2);
    }
}
