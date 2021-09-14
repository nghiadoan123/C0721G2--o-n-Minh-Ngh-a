package _09_danh_sach.exercise.linked_list;



public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.add(1,35);
        ll.add(45);
        ll.add(2,85);
        ll.add(65);
        ll.addLast(120);
        ll.printList();
        System.out.println("index= "+ll.indexOf(150));
        System.out.println(ll.contains(850));
        ll.remove(0);
        ll.printList();
    }
}
