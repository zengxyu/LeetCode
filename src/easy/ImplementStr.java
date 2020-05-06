package easy;

/**
 * Program: LeetCode
 * Description: Implement strStr().  Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-04 15:41
 **/
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length()==0 && needle.length()==0){
            return 0;
        }
        int len = needle.length();
        for (int i = 0; i <= haystack.length()-len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
            ;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr implementStr = new ImplementStr();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(implementStr.strStr(haystack, needle));
    }
}
