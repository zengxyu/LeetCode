package medium;

import java.util.ArrayList;

import java.util.List;

/**
 * Program: LeetCode
 * Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-07 14:16
 **/
public class LongestPalindromicSubstring {
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * ����ַ�������Ϊ10���Ƚ�ȡ����Ϊ10���ַ������ٽ�ȡ����Ϊ9���ַ������ٽ�ȡ����Ϊ8���ַ���������
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String result = "";
        int len = s.length();
        while (len >= 0) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String temp = s.substring(i, i + len);
                if (isPalindrome(temp)) {
                    result = temp;
                    return result;
                }
            }
            len--;
        }
        return result;
    }

    /**
     * i����㣬j���յ㣬˫��ѭ����ÿ�ν�ȡ��ÿ�α���
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxSize = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (j - i < maxSize) {
                    break;
                }
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp)) {
                    if (temp.length() > maxSize) {
                        maxSize = temp.length();
                        result = temp;
                    }
                    break;
                }
            }
        }
        return result;
    }

    /***
     * ������չ
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int maxSize = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (j - i < maxSize) {
                    break;
                }
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp)) {
                    if (temp.length() > maxSize) {
                        maxSize = temp.length();
                        result = temp;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "a";
        LongestPalindromicSubstring longestPalindrome = new LongestPalindromicSubstring();
//        System.out.println(longestPalindrome.isPalindrome("absba"));
        System.out.println(longestPalindrome.longestPalindrome2(s));
    }
}
