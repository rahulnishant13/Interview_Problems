package Interviews;

import java.util.Arrays;

public class CombinationSumIV_InfoWorks {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
    private static int combinationSum4(int[] nums, int target) {
        int N = nums.length;
        int[] result = new int[target+1];
        result[0] = 1;

        for (int t = 1; t <= target; t++) {
            for (int i = 0; i < N; i++) {
                if(t - nums[i] >= 0){
                    result[t] += result [t - nums[i]];
//                    System.out.println(Arrays.toString(result));
                }
            }
//            System.out.println();
        }

        return result[target];
    }
}
