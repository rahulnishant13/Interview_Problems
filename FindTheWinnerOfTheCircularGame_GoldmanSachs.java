package Interviews;

import java.util.LinkedList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame_GoldmanSachs {
    public static void main(String[] args) {
        int n = 5, k = 3;

        System.out.println(findTheWinner(n, k));
    }

    private static int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k -= 1;
        int counter = k;
        while(list.size() > 1){
            if(list.size() > counter){
                list.remove(counter);
                counter += k;
            } else {
                counter -= list.size();
            }
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}
