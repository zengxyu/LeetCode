import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Given two binary strings, return their sum (also a binary string).  The input strings are both non-empty and contains only characters 1 or 0.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 15:30
 **/
public class AddBinary {
    public String addBinary(String a, String b) {
        List<Integer> result = new ArrayList<Integer>();
        int pre = 0;
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        while (a_index >= 0 || b_index >= 0) {
            int a_bit = 48;
            int b_bit = 48;
            if (a_index >= 0) {
                a_bit = a.charAt(a_index);
            }
            if (b_index >= 0) {
                b_bit = b.charAt(b_index);
            }

            int sum = a_bit + b_bit;
            // 0==48  1==49
            if (sum == '0' + '0') {
                if (pre == 1) {
                    result.add(0, 1);
                    pre = 0;
                } else {
                    result.add(0, 0);
                    pre = 0;
                }
            } else if (sum == '0' + '1') {
                if (pre == 1) {
                    result.add(0, 0);
                    pre = 1;
                } else {
                    result.add(0, 1);
                    pre = 0;
                }
            } else if (sum == '1' + '1') {
                if (pre == 1) {
                    result.add(0, 1);
                    pre = 1;
                } else {
                    result.add(0, 0);
                    pre = 1;
                }
            }
            a_index--;
            b_index--;
        }
        if (pre == 1){
            result.add(0,1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a,b));;
    }
}
