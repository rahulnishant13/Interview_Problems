package Interviews;

/*
Given a string, restore valid lottery numbers. For example, “4938532894754” is given, the answer will be [“49 38 53 28 9 47 54”].

The problem description sometimes starts from “uncle, Morty.”

Your facorite uncle, Morty, is crazy about the lottery and even crazier about how he picks his “lucky” numbers…

constraints to make it valid.
    valid lottery numbeers should have 7 parts separated by “ “(space).
    each digits must be between 1 and 59
    all digits are unique
    must use all characters in the same order
The idea to split a string to make lottery numbers
This is almost identical to valid IP address problem. The small differences are from four parts to seven, from dot to space, and from 0-255 to 1-59. Relaitvely big difference is, in lottery problem, each digit is unique.

To check uniqueness, I added a set in the DFS interation: add the number to set when going deeper, remove the number when coming back.
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RestoreLotteryNumbers_DailPad {
    public static void main(String[] args) {
        String s;
        s = "4938532894754";
        System.out.println(restoreLotteryNumbers(s));
        s = "1634616512";
        System.out.println(restoreLotteryNumbers(s));
        s = "11223344";  // invalid, no result
        System.out.println(restoreLotteryNumbers(s));
    }

    private static List<String> restoreLotteryNumbers(String s) {
        List<String> result = new ArrayList<>();
        if(s.isEmpty()) return result;
        restoreLotteryNumbers(s, result, new HashSet<String>(), "", 0, 0);
        return result;
    }

    private static void restoreLotteryNumbers(String s, List<String> result, HashSet<String> seen, String number, int count, int index) {
        if(count > 7) return;

        if(count == 7 && number.length() == (s.length() + 6)){
            result.add(number);
        }
        for(int i = 1; i <= 2; i++){
            if(i + index > s.length()) break;
            String sub = s.substring(index, index+i);
            if(seen.contains(sub) || (Integer.parseInt(sub) > 59) || (Integer.parseInt(sub) < 1)){
                continue;
            } else {
                seen.add(sub);
                String next = number + sub + (count == 6 ? "":" ");
                restoreLotteryNumbers(s, result, seen, next, count+1, index+i);
                seen.remove(sub);
            }
        }
    }
}
