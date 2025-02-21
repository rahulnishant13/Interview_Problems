/**
Being asked in ThoughtSpot PS DS round
there is a matrix of n*m, need to find minimum distance to reach to (n-1, m-1) stating from (0,0).
Condition steps can be take left, right, up, down and each step count plus 1.
And matrix contain few similar numbers other than zero which act as portal and can moved form one to another using one step.
[[0,3,0,0],
 [0,0,0,0],
 [0,0,3,0],
 [4,0,0,0],
 [0,0,4,0]]
**/

import java.util.*;

public class MininumDistance_ThoughtSpot {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 3, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 3, 0},
                {4, 0, 0, 0},
                {0, 0, 4, 0}
        };

        // Find the minimum distance to reach (n-1, m-1) from (0, 0)
        int minDist = getMinDistance(matrix);
        System.out.println("Minimum distance: " + minDist);
    }

    private static Map<Integer, List<int[]>> portalMap = new HashMap<>();

    private static int getMinDistance(int[][] matrix) {

//        to store all portals available and compute it before hand
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    portalMap.putIfAbsent(matrix[i][j], new ArrayList<>());
                    portalMap.get(matrix[i][j]).add(new int[]{i, j});
                }
            }
        }

//        to keep track of nodes that has been already computed
        Set<String> visited = new HashSet<>();
        visited.add(0 +","+ 0);

//        initializing queue with start position and step will be 0;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        int[] row = new int[]{-1,1,0,0};
        int[] col = new int[]{0,0,-1,1};
        //                i-1,j;
        //                i+1,j;
        //                i,j-1;
        //                i,j+1;

        while(!queue.isEmpty()){
            int[] currPositionData = queue.poll();
            int currRow = currPositionData[0];
            int currCol = currPositionData[1];
            int currStep = currPositionData[2];

            if(currRow == matrix.length-1 && currCol == matrix[0].length-1){
                return currStep;
            }

            for (int i = 0; i < 4; i++) {
                int r = currRow + row[i];
                int c = currCol + col[i];
                if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length){
                    if(!visited.contains(r+","+c)) {
                        visited.add(r+","+c);
                        queue.add(new int[]{r, c, currStep + 1});
                    }
                }
            }
            if(matrix[currRow][currCol] != 0){
                for (int[] portal : portalMap.get(matrix[currRow][currCol])){
                    int r = portal[0];
                    int c = portal[1];
                    if(!visited.contains(r+","+c)) {
                        visited.add(r+","+c);
                        queue.add(new int[]{r, c, currStep + 1});
                    }
                }
            }
        }

        return -1;
    }
}
