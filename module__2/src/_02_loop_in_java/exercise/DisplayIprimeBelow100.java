package _02_loop_in_java.exercise;
public class DisplayIprimeBelow100 {
    public static void main(String[] args) {
        int number;
        boolean flag;
        int n = 2;
        String result = "";
        while (n<100) {
            flag = true;
            if (n < 2) {
                flag = false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                   if (n<100){
                       if (n % i == 0) {
                           flag = false;
                           break;
                       }
                   } else {
                       break;
                   }
                }
            }
            if (flag) {
                System.out.print(result = n + " ");
            }
            n++;
        }
    }
}
