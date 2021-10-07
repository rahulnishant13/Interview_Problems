package Interviews;

import java.util.Stack;

public class CreatingASchoolHostelAssignment_Bigbasket {
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
        String str = "init 13 \n" +
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
                "fin";
        String [] strArr = str.split("\n");

        // number of student inputs
        int n = Integer.valueOf(strArr[0].split(" ")[1]);

        Stack<Integer> AV = new Stack<>();
        Stack<Integer> BV = new Stack<>();
        Stack<Integer> ANV = new Stack<>();
        Stack<Integer> BNV = new Stack<>();

        for (int i = 1; i <= n; i++) {
            String [] row = strArr[i].split(" ");
            if(row[0].equals("reg")){ // not required can get rid of it as all are reg case
                switch(row[2]+row[3]){
                    case "AV":
                        AV.add(Integer.valueOf(row[1]));
                        break;
                    case "BV":
                        BV.add(Integer.valueOf(row[1]));
                        break;
                    case "ANV":
                        ANV.add(Integer.valueOf(row[1]));
                        break;
                    case "BNV":
                        BNV.add(Integer.valueOf(row[1]));
                        break;
                }
            }
        }
        int min_size = Math.min(AV.size(), Math.min(BV.size(), Math.min(ANV.size(), BNV.size())));
        Stack<Integer> NA = new Stack<>();
        trimHouse(AV, NA, min_size);
        trimHouse(BV, NA, min_size);
        trimHouse(ANV, NA, min_size);
        trimHouse(BNV, NA, min_size);

        System.out.println("BV : "+ BV.toString());
        System.out.println("AV : "+ AV.toString());
        System.out.println("BNV : "+ BNV.toString());
        System.out.println("ANV : "+ ANV.toString());
        System.out.println("NA : "+ NA.toString());

    }

    private static void trimHouse(Stack<Integer> queue, Stack<Integer> NA, int min_size){
        for (int i = min_size; i < queue.size(); i++) {
            NA.add(queue.pop());
        }
    }

}
