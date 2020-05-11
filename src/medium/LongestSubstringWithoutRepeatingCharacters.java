package medium;

import java.util.ArrayList;

import java.util.List;

/**
 * Program: LeetCode
 * Description: Given a string, find the length of the longest substring without repeating characters.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 21:23
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        for (int i = 0; i < s.length(); ++i) {
            List<Character> list = new ArrayList();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                int index = list.indexOf(c);
                if (index < 0) {
                    list.add(s.charAt(j));
                } else {
                    if (list.size() > maxSize) {
                        maxSize = list.size();
                    }
                    list = new ArrayList();
                    i = i + index;
                    break;
                }
            }
            if (list.size() > maxSize) {
                maxSize = list.size();
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstring = new LongestSubstringWithoutRepeatingCharacters();
//        String s = "aab";
        String s = "vchuuluxyabicfrpa";
//        System.out.println(s.charAt(0));
        System.out.println(longestSubstring.lengthOfLongestSubstring(s));
    }
}
