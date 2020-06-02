package medium;

/**
 * 顺时针旋转矩阵90度 --- 转置
 */
public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        /**
         * 如果
         * 旧的纵坐标等于新的横坐标，
         * 旧的横坐标等于len-1-新的纵坐标
         * [0,0] -> [0,2],
         * [0,1] -> [1,2],
         * [0,2] -> [2,2]
         *
         * [2,2] -> [2,0]
         * [2,1] -> [1,0]
         * [2,0] -> [0,0]
         */
        // 当 i = 0 时，循环的是第一圈（外圈）；当i = 1时，循环的是第二圈(由外向内)；当i=2时，循环的是第三圈
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int i_cur = i;
                int j_cur = j;
                int i_n = j_cur;
                int j_n = matrix.length - 1 - i_cur;
                int store_cur = matrix[i_cur][j_cur];
                int store_n = matrix[i_n][j_n];
                matrix[i_n][j_n] = store_cur;
                // while循环表示 1->3,3->9,9->7,7->1, 回到起点的时候终止
                while (!(i_n == i && j_n == j)) {
                    i_cur = i_n;
                    j_cur = j_n;
                    i_n = j_cur;
                    j_n = matrix.length - 1 - i_cur;
                    store_cur = store_n;
                    store_n = matrix[i_n][j_n];
                    matrix[i_n][j_n] = store_cur;
                }
            }
        }
    }

    public static void main(String[] args) {
        RotateImage_48 rotateImage = new RotateImage_48();
//        int[][] matrix = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},

        };
        rotateImage.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            System.out.print("[");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("]");

        }

    }
}
