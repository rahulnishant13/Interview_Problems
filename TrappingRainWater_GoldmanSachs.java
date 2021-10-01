package Interviews;

import java.util.Arrays;

public class TrappingRainWater_GoldmanSachs {
    public static void main(String[] args) {
        int [] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(heights));
    }

    private static int trap(int[] height) {
        int [] lh = new int[height.length];
        int [] rh = new int[height.length];
        int lhm = height[0], rhm = height[height.length -1];

        for(int i=0; i<height.length; i++){
            if(lhm < height[i]){
                lhm = height[i];
            }
            lh[i] = lhm;
        }

        for(int i=height.length-1; i>=0; i--){
            if(rhm < height[i]){
                rhm = height[i];
            }
            rh[i] = rhm;
        }

        System.out.println(Arrays.toString(lh));
        System.out.println(Arrays.toString(rh));


        int total = 0;
        for(int i=0; i<height.length; i++){
            total += Math.min(lh[i], rh[i]) - height[i];
        }

        return total;
    }
}
