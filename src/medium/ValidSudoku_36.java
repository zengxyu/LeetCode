package medium;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; j++) {
                char item = board[i][j];
                if (item == '.') {
                    continue;
                } else {
                    //比较一横排有没有重复的
                    for (int k = j + 1; k < board[i].length; ++k) {
                        if (item == board[i][k]) {
                            //System.out.println("row: item = " + item + ";board[i][k]:" + board[i][k]);
                            return false;
                        }
                    }
                    //比较一纵列有没有重复的
                    for (int k = i + 1; k < board[i].length; ++k) {
                        if (item == board[k][j]) {
                            // System.out.println("col:");
                            return false;
                        }
                    }
                    //比较3x3的子格有没有重复的
                    int row_start = (i / 3) * 3;
                    int col_start = (j / 3 ) * 3;
                    int row_end = (i / 3 + 1) * 3;
                    int col_end = (j / 3 + 1) * 3;
                    for (int m = row_start; m < row_end; m++) {
                        for (int n = col_start; n < col_end; n++) {
                            if (i == m && j == n) {
                                continue;
                            }
                            if (item == board[m][n]) {
                                //System.out.println("sub box:" + board[m][n]);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 validSudoku_36 = new ValidSudoku_36();
    }
}