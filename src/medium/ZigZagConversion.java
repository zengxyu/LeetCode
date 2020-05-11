package medium;

/**
 * Program: LeetCode
 * Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-07 16:24
 **/
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        // 处理特殊边界情况
        if (s.length() == 0 || s.length() == 1 || numRows == 1) {
            return s;
        }
        // 获得数组列数
        int numCols = (s.length() / numRows + 1)  * (numRows - 1);
        char[][] chars = new char[numRows][numCols];
        int row_index = 0;
        int col_index = 0;
        chars[0][0] = s.charAt(0);
        //把元素放在应该在的位置
        // 主要在于元素的索引的值
        for (int i = 1; i < s.length(); i++) {
            int mul = (numRows - 1);
            if ((i - 1) / mul % 2 == 0) {
                row_index = (i - 1) % mul + 1;
            } else if ((i - 1) / mul % 2 == 1) {
                col_index++;
                row_index--;
            }
            chars[row_index][col_index] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; j++) {
                char c = chars[i][j];
                if (c!='\0'){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZagConversion zagConversion = new ZigZagConversion();
        System.out.println(zagConversion.convert(s, 4));
        ;
    }
}
