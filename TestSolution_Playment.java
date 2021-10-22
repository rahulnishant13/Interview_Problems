package Interviews;

import java.util.Arrays;

public class TestSolution_Playment {
    public static void main(String args[] ) throws Exception {
        int n = 5;

        int [] arr = {45,32,13,12,78};
        int num_tomove = 1;
        int [] val_arr = {12,45};

        int [] num = new int[3];
        for (int i = 0; i < n; i++) {
            if(arr[i] == val_arr[0]){
                if(i+num_tomove < n){
                    num[0] = arr[i+num_tomove];
                    num[1] = i+num_tomove;
                }
            }
            if(arr[i] == val_arr[1]){
                num[2] = i;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if(i >= num[1]){
                arr[i] = arr[i+1];
            }
        }
        arr[n-1] = 0;
        if(num[2] == n-1){
            arr[n-1] = num[0];
        } else {
            int temp = num[0];
            for (int i = 0; i < n; i++) {
                if(i > num[2]){
                    int x = arr[i];
                    arr[i] = temp;
                    temp = x;
                }
            }
        }
        System.out.println("result " + Arrays.toString(arr) + ".");
    }
}
