/**
Problem:
You are given an n×m matrix where each element is either a zero or a positive integer representing a portal.
The goal is to find the minimum distance from the top-left corner (0,0) to the bottom-right corner (n-1, m-1).
You can move in four directions (up, down, left, right), and each step you take counts as 1 in the distance.
However, if you land on a cell containing a portal number (other than 0), you can "teleport" to another cell with the same portal number in one step.
Requirements:
Start from the cell (0,0) and reach (n-1,m-1).
Movement is allowed in the four cardinal directions (up, down, left, right).
Each step taken adds 1 to the total distance.
Cells containing the same positive integer (portals) allow teleportation between them, and it counts as just 1 step.
Find the minimum distance to reach the destination.
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
