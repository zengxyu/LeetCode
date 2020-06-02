package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * <p>
 * [0,0][0,1][0,2]
 * [1,0][1,1][1,2]
 * [2,0][2,1][2,2]
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {

            //from left to right

            for (int j = cStart; j <= cEnd; ++j) {
                res.add(matrix[rStart][j]);
            }
            // from top-right to down-right
            for (int i = rStart + 1; i <= rEnd - 1; i++) {

                res.add(matrix[i][cEnd]);
            }
            // from down-right to down-left
            for (int j = cEnd; j >= cStart; j--) {
                if (rStart == rEnd) {
                    break;
                }
                res.add(matrix[rEnd][j]);
            }
            // from down-left to top-left
            for (int i = rEnd - 1; i >= rStart+1; i--) {
                if (cStart == cEnd) {
                    break;
                }
                res.add(matrix[i][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
        };
        SpiralMatrix_54 spiralMatrix_54 = new SpiralMatrix_54();
        List<Integer> res = spiralMatrix_54.spiralOrder(matrix);
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.print("]");
    }
}
