package _11_stack_queue.exercise;

import java.util.*;

public class UseMapCountElement {
    public static void main(String[] args) {
        String str = "hello words words";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        // c3 dùng entry đê truy cập các phần tử của map
//        for (Map.Entry<String,Integer> entry: map.entrySet()) {
//            System.out.println(entry.getKey()+ " xuất hiện: "  + entry.getValue()+ "lần" );
//        }
        // c1 dùng generic <>
        //Set<String> set = map.keySet();
        //        for (String sets : set) {
//            System.out.println("Key: " + sets + "xuất hiện: " + map.get(key) + "lần");
//        }
        // c2 dùng interator
        Set<String> set = map.keySet();
        Iterator iterator = set.iterator();

        for (int i = 0; iterator.hasNext() ; i++) {
            key = (String) iterator.next();
            System.out.println("'"+key + "' xuất hiện "+ map.get(key) +" lần");
        }
//
//        while (iterator.hasNext()) {
//            key = (String) iterator.next();
//           // key = ((String) iterator.next()).toUpperCase();
//            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
//
//        }
    }
}
