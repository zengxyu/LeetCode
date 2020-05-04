import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        boolean flag = true;
        if (strs.length ==0){
            return "";
        }
        while (flag) {
            if (k >= strs[0].length()) {
                break;
            }
            char a = strs[0].charAt(k);
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (k == str.length()||str.charAt(k)!= a) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(a);
                k++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strings = new String[]{"a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings));
        ;
    }
}
