import java.util.List;

import java.util.ArrayList;

/**
 * Program: LeetCode
 * Description: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.  The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.  You may assume the integer does not contain any leading zero, except the number 0 itself.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 14:53
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int pre = 0;
        int digit = digits[digits.length - 1] + 1;
        if (digit == 10) {
            digits[digits.length - 1] = 0;
            pre = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (pre == 1) {
                    digits[i] = digits[i] + 1;
                    if (digits[i] == 10) {
                        digits[i] = 0;
                        pre = 1;
                    } else {
                        pre = 0;
                    }
                }
            }
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }

        if (digits[0] == 0){
            int[] digits2 = new int[digits.length+1];
            digits2[0] = 1;
            for (int i = 1; i < digits2.length; ++i) {
                digits2[i] = digits[i-1];
            }
            return digits2;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(plusOne.plusOne(nums));
    }
}
