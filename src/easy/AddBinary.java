package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Given two binary strings, return their sum (also a binary string).  The input strings are both non-empty and contains only characters 1 or 0.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 15:30
 * What I got from this question ?
 * 1）能在list或stringbuffer后面加入，就在后面加入后再reverse都行,
 * 因为insert或add(0,x)都会让后面的元素逐个向后移，会花费大量时间?
 * 2）利用好 或 余数
 **/
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        while (a_index >= 0 || b_index >= 0) {
            int sum = pre;
            if (a_index >= 0) {
                sum += a.charAt(a_index) - '0';
            }
            if (b_index >= 0) {
                sum += b.charAt(b_index) - '0';
            }
            // 0==48  1==49
            sb.append(sum % 2);
            pre = sum / 2;
            a_index--;
            b_index--;
        }
        if (pre == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }
}
