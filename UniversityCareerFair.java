package Interviews;

import java.util.Arrays;

public class UniversityCareerFair {
    public static void main(String[] args) {
        int [] compArrival = {1,3,3,5,7};
        int [] compDuration = {2,2,1,2,1};

        System.out.println(num_maxEvents(compArrival, compDuration));
    }

    public static int num_maxEvents (int[] arr, int[]dur) {
        int drop = 0;
        int NumOfEvents = arr.length;
        int [][] intervals = new int[NumOfEvents][2];

        for (int i = 0; i < NumOfEvents; i++) {
            intervals[i] = new int[] {arr[i], arr[i] + dur[i]};
        }

        Arrays.sort(intervals, (a, b) ->(a[1] - b[1]));
        // the finish time of first event;
        int curTime = intervals[0][1];

        for (int i = 1; i < NumOfEvents; i++) {
            int [] toSchedual = intervals[i];
            if (toSchedual[0] < curTime)
                drop++;
            else {
                curTime = toSchedual[1];
            }
        }
        return NumOfEvents - drop;


    }
}
