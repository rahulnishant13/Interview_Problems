package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CSHA_Bisgbasket_map {
    public static void main(String[] args) {
//        String str = "init 12 \n" +
//                "reg 1 B V \n" +
//                "reg 2 A V \n" +
//                "reg 3 A V \n" +
//                "reg 4 B NV \n" +
//                "reg 5 B V \n" +
//                "reg 6 A NV \n" +
//                "reg 7 A V \n" +
//                "reg 8 A NV \n" +
//                "reg 9 B NV \n" +
//                "reg 10 B V \n" +
//                "reg 11 A NV \n" +
//                "reg 12 B NV \n" +
//        "fin";
        String str = "init 14 \n" +
                "reg 1 B V \n" +
                "reg 2 A V \n" +
                "reg 3 A V \n" +
                "reg 4 B NV \n" +
                "reg 5 B V \n" +
                "reg 6 A NV \n" +
                "reg 7 A V \n" +
                "reg 8 A NV \n" +
                "reg 9 B NV \n" +
                "reg 10 B V \n" +
                "reg 11 A NV \n" +
                "reg 12 B NV \n" +
                "reg 13 A NV \n" +
                "reg 14 B NV \n" +
                "fin";
        String [] strArr = str.split("\n");

        // number of student inputs
        int n = Integer.valueOf(strArr[0].split(" ")[1]);

        Map<String, Stack<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String [] row = strArr[i].split(" ");
            Stack<Integer> temp = new Stack<>();
            if(row[0].equals("reg")){ // not required can get rid of it as all are reg case
                String tempSt = row[2]+row[3];
                if(map.containsKey(tempSt))
                    temp = map.get(tempSt);
                temp.add(Integer.valueOf(row[1]));
                map.put(tempSt, temp);
            }
        }
        int min_size = Math.min(map.get("AV").size(), Math.min(map.get("BV").size(), Math.min(map.get("ANV").size(), map.get("BNV").size())));
        Stack<Integer> NA = new Stack<>();
        trimHouse(map.get("BV"), NA, min_size);
        trimHouse(map.get("AV"), NA, min_size);
        trimHouse(map.get("BNV"), NA, min_size);
        trimHouse(map.get("ANV"), NA, min_size);

        System.out.println("BV : "+ map.get("BV"));
        System.out.println("AV : "+ map.get("AV"));
        System.out.println("BNV : "+ map.get("BNV"));
        System.out.println("ANV : "+ map.get("ANV"));
        System.out.println("NA : "+ NA.toString());

        System.out.println();

    }

    private static void trimHouse(Stack<Integer> queue, Stack<Integer> NA, int min_size){
        for (int i = min_size; i < queue.size(); i++) {
            NA.add(queue.pop());
        }
    }
}
