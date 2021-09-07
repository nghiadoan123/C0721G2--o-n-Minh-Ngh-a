public class demo1 {
    static {
        System.out.println("Khoi static duoc trieu hoi");
    }

//    int countDifferentCharacters(String s) {
//        String c="";
//        for (int i=0; i < s.length(); i++) {
//            if(!c.contains(""+s.charAt(i))) {
//                c+=s.charAt(i);
//            }
//        }
//        return c.length();
//    }
    int countDifferentCharacters(String s) {
        String c="";
        for (int i=0; i < s.length(); i++) {
            if(!c.contains(String.valueOf(s.charAt(i)))) {
                c+=String.valueOf(s.charAt(i));
            }
        }
        return c.length();
    }
    public static void main(String args[]) {
       // System.out.println("Hello main");
        demo1 demo1 = new demo1();
        System.out.println(demo1.countDifferentCharacters("abcasdjjf"));

    }
}
