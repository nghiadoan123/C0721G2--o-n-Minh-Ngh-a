package Demo1;

//public class Simple extends Demo1 {
    // do lớp cha demo1 có hàm msg là protected nên lớp simple cũng phải là protected
    // nếu để defaulr thì sẽ bị lỗi khi dùng ghi đè phuwowg thưc override
//  vd lỗi
//  void msg() {
//        System.out.println("Hello java of simple");
//    }
//     void msg() {
//        System.out.println("Hello java of simple");
//    }
//
//    public static void main(String args[]) {
//        Simple obj = new Simple();
//        obj.msg();
//    }
    class Simple {
        void method(Demo1 x) {
            x.rong = 5;
            x.dai = 5;
        }

        public static void main(String[] args) {
            Simple o = new Simple();
            Demo1 cn = new Demo1(1, 1);
            o.method(cn);
            System.out.printf("x=%d, y=%d", cn.rong, cn.dai);
        }
}
