package Interviews;

import java.util.Arrays;

public class MeandringArray_BookingCom {
    public static void main(String[] args) {
        int [] arr = new int[]{5,2,7,8,-2,25,25};//{-1,1,2,3,-5, 0};
        arr = createMeandringArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] createMeandringArray(int [] arr){
        Arrays.sort(arr);
        int [] result = new int[arr.length];
        int i = 0, j = arr.length-1, k=0;

        while (i < j){
            result[k++] = arr[j--];
            result[k++] = arr[i++];
        }
        if (arr.length%2 != 0)
            result[k] = arr[i];

        return result;
    }
}
