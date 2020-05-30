package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 */
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        List<String> list = new ArrayList<>();
        int count = 0;
        // 123 * 456 分解为 123*6, 123*5, 123*4
        for (int i = num2.length() - 1; i >= 0; i--) {
            int mul = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int multiplicand = num1.charAt(j) - '0';
                int product = multiplicand * mul;
                int curRes = product + carry;
                sb.append(curRes % 10);
                carry = curRes / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            //123*4时要错一位
            for (int j = 0; j < count; j++) {
                sb.insert(0, 0);
            }
            list.add(sb.toString());
            count++;
        }
        Collections.reverse(list);
        StringBuilder res = new StringBuilder();
        int max_len = list.get(0).length();
        int carry = 0;
        for (int i = 0; i < max_len; i++) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                String temp = list.get(j);
                if (i < temp.length()) {
                    sum += (temp.charAt(i) - '0');
                }
            }
            int curRes = sum + carry;
            res.append(curRes % 10);
            carry = curRes / 10;
        }
        if (carry > 0) {
            res.append(carry);
        }
        String res2 = res.reverse().toString();
        //排除开头为0的情况，这种情况只有在整个字符串都是0的时候出现
        return res2;
    }

    public static void main(String[] args) {
        MultiplyStrings_43 multiplyStrings_43 = new MultiplyStrings_43();
        multiplyStrings_43.multiply("140", "721");
    }
}
