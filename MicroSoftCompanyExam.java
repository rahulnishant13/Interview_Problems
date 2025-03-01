/**
 * there is a small, one way bridge that can carry a maximum weight of U units at a time, there is also a line of N cars waiting to cross the bridge. The weights of the cars are given as an array weight. The weight of the kth car in line is weight[k] (for K in range [0...n-1]. The car that will enter the bridge first weighs weight[0], the car that will enter second weights weight[1] and so on.
 *
 *
 * At most two cars can be on the bridge at the same time. To begin, the first two cars in line will enter the bridge. Then the third car will enter the bridge as soon as the first car leaves the bridge, the fourth car will enter when the second car leaves, and so on. The cars leave the bridge in the same order they entered it.
 * However, this may lead to a situation where cars exceed the bridge's weight limit. To prevent such a situation, some drivers have to turn back. When a driver turns back, all drivers behind them in line move one position closer to the bridge. The driver who turns back is removed from the line and will not try to cross the bridge again.
 * Your task is to find the minimum number of drivers that must turn back so that the bridge will not be overloaded.
 * Write a function:
 * class Solution i public int solution(int U, intll weight) : }
 *
 *
 * that given an integer U representing the weight limit of the bridge and an array weight of N integers representing the weihts cars in line, returns the minimum number of drivers that must turn back so that the bridge will not be overloaded.
 *
 *
 * For U = 9 and weight = [5, 3, 8, 1, 8, 7, 7, 6|, the function should return 4. After the 3rd, 5th, 6th
 * and 7th cars turn back, the weights of the remaining cars in line are (5, 3, 1, 6]. Notice that instead of the 5th, 6th and 7th cars, any three of the last four cars can turn back to obtain an optimal answer. The cars will then cross the bridge as follows:
 * the 1st car (weight 5) enters the bridge;
 * the 2nd car (weight 3) enters the bridge, the total weight of cars on the bridge is 5 +
 * 3 = 8;
 * the 1st car (weight 5) leaves the bridge;
 * the 3rd car (weight 1) enters the bridge, the total weight of cars on the bridge is 3 +
 * 1 = 4;
 * the 2nd car (weight 3) leaves the bridge;
 * the 4th car (weight 6) enters the bridge, the total weight of cars on the bridge is 1 +
 * 6 = 7;
 * the 3rd car (weight 1) leaves the bridge;
 * the 4th car (weight 6) leaves the bridge.
 * During this process, the total weight of cars on the bridge does not exceed 9.
 * For U = 7 and weight = 17, 6, 5, 2, 7, 4, 5, 4], the function should return 5. After the 1st, 2nd, 5th,
 * 6th and 7th cars turn back, the weights of the remaining cars in line are [5, 2, 4). Notice that instead of the 6th and 7th cars, any two of the last three cars can turn back to obtain an optimal answer.
 * For U = 7 and weight = [3, 4, 3, 1], the function should return 0. There is no need for any car to turn back
 * write an efficient algorithm for the following assumptions
 * N is an integer within the range [1..100,000]
 * each element of array weight is an integer within the range [1..1,000,000,000]
 * U is an integer within the range [1..1,000,000,000]
 * */


public class MicroSoftCompanyExam {
    public static void main(String[] args) {
        System.out.println(numOfReturnCars(new int[]{7, 6, 5, 2, 7, 4, 5, 4}, 7));
        System.out.println(numOfReturnCars(new int[]{5, 3, 8, 1, 8, 7, 7, 6}, 9));
        System.out.println(numOfReturnCars(new int[]{3, 4, 3, 1}, 7));

    }

    private static int numOfReturnCars(int[] weights, int capacity) {
        int result = 0;
        int prevCar = 0;

        for(int nextCar : weights){
            if(prevCar + nextCar > capacity) {
                result++;
                prevCar = Math.min(prevCar, nextCar);
            } else {
                prevCar = nextCar;
            }
        }

        return result;
    }
}
