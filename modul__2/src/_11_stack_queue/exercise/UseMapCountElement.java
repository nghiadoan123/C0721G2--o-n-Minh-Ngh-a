package _11_stack_queue.exercise;

import java.util.*;

public class UseMapCountElement {
    public static void main(String[] args) {
        String str = "hello words hello words";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        Set<String> set = map.keySet();
        //Iterator iterator = set.iterator();
        // c1
        for (String sets : set) {
            System.out.println("Key: " + sets + "xuất hiện: " + map.get(key) + "lần");
        }
        // c2
//        while (iterator.hasNext()) {
//            key = (String) iterator.next();
//           // key = ((String) iterator.next()).toUpperCase();
//            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
//        }
    }
}
