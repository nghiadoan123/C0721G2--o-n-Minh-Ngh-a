public class DemTongKyTuKhongTrungNhauTrongChuoi {
    //c1
    int countDifferentCharacters(String s) {
        String c="";
        for (int i=0; i < s.length(); i++) {
            if(!c.contains(String.valueOf(s.charAt(i)))) {
                c+=String.valueOf(s.charAt(i));
            }
        }
        return c.length();
    }
    //c2
//    int countDifferenrcharacter1(String s){
//        int count =0;
//        int len = s.length();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j <s.length() ; j++) {
//                if (s.charAt(i) == s.charAt(j)){
//                    count++;
//                    break;
//                }
//            }
//        }
//        return len -= count ;
//    }

    public static void main(String[] args) {
        DemTongKyTuKhongTrungNhauTrongChuoi demTongKyTuKhongTrungNhauTrongChuoi = new DemTongKyTuKhongTrungNhauTrongChuoi();
        int count = demTongKyTuKhongTrungNhauTrongChuoi.countDifferentCharacters("abcaad");
        System.out.println(count);
        int d = demTongKyTuKhongTrungNhauTrongChuoi.countDifferentCharacters("abcaad");
        System.out.println(d);
    }
}
