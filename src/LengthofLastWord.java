/**
 * Program: LeetCode
 * Description: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.  If the last word does not exist, return 0.  Note: A word is defined as a maximal substring consisting of non-space characters only.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 14:46
 **/
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s .equals("") || s.equals(" ")){
            return 0;
        }
        String[] s_array =  s.split(" ");
        return s_array[s_array.length-1].length();
    }
    public static void main(String[] args) {

    }
}
