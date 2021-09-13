package _09_danh_sach.exercise.trien_khai_phuong_thuc_arraylist_theo_thu_vien_java;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.add(2);
        listInteger.add(1,3);
        listInteger.remove(2);

        System.out.println("element 4: "+listInteger.get(0));
        System.out.println("element 4: "+listInteger.get(1));
        System.out.println("element 4: "+listInteger.get(2));
        System.out.println("element 4: "+listInteger.get(3));

        System.out.println(listInteger.size());
        System.out.println(listInteger.contains(5));
       // listInteger.clear();
        System.out.println(listInteger.addElement(3));
        System.out.println("element 4: "+listInteger.get(3));

    }
}
