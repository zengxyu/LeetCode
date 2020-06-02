package medium;

import java.util.List;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[] nums = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            nums[i] = i+1;
        }

        int cStart = 0;
        int cEnd = n - 1;
        int rStart = 0;
        int rEnd = n - 1;
        int index = 0;
        while (cStart <= cEnd && rStart <= rEnd) {
            for (int col = cStart; col <= cEnd; col++) {
                matrix[cStart][col] = nums[index];
                index++;
                if (index==nums.length){
                    return matrix;
                }
            }
            for (int row = rStart + 1; row < rEnd; row++) {
                matrix[row][cEnd] = nums[index];
                index++;
                if (index==nums.length){
                    return matrix;
                }
            }
            for (int col = cEnd; col >= cStart; col--) {
                matrix[rEnd][col] = nums[index];
                index++;
                if (index==nums.length){
                    return matrix;
                }
            }
            for (int row = rEnd - 1; row > rStart; row--) {
                matrix[row][cStart] = nums[index];
                index++;
                if (index==nums.length){
                    return matrix;
                }
            }
            cStart++;
            cEnd--;
            rStart++;
            rEnd--;
        }
        return matrix;
    }
    public static void main(String[] args) {
        SpiralMatrixII_59 spiralMatrix = new SpiralMatrixII_59();
        int[][]res = spiralMatrix.generateMatrix(3);
//        System.out.println();
//        System.out.print("[");
//        for (int i = 0; i < res.size(); i++) {
//            System.out.print(res.get(i) + ",");
//        }
//        System.out.print("]");
    }
}
