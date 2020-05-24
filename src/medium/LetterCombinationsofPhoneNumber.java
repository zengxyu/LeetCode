package medium;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */

public class LetterCombinationsofPhoneNumber {
    static Map<Character, String> hashMap = new HashMap<>();

    static {
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<List<Character>> res = new ArrayList<>();
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            if (list.size() == 0) {
                char d = digits.charAt(i);
                String value = hashMap.get(d);
                for (int j = 0; j < value.length(); j++) {
                    char c = value.charAt(j);
                    List<Character> temp = new ArrayList<>();
                    temp.add(c);
                    list.add(temp);
                    res.add(temp);
                }
            } else {
                char d = digits.charAt(i);
                String value = hashMap.get(d);
                res.clear();
                for (int k = 0; k < list.size(); k++) {
                    List<Character> temp = list.get(k);
                    for (int j = 0; j < value.length(); j++) {
                        List<Character> temp2 = new ArrayList<>(temp);
                        temp2.add(value.charAt(j));
                        res.add(temp2);
                    }
                }
                list = new ArrayList<>(res);
            }
        }

        List<String> results = new ArrayList<>();
        for (int j = 0; j < res.size(); j++) {
            StringBuilder builder = new StringBuilder();
            for (Character character : res.get(j)) {// 对ArrayList进行遍历，将字符放入StringBuilder中
                builder.append(character);
            }
            System.out.println(builder.toString());
            results.add(builder.toString());
        }
        return results;
    }

    public static void main(String[] args) {
        LetterCombinationsofPhoneNumber letterCombinationsofPhoneNumber = new LetterCombinationsofPhoneNumber();
        letterCombinationsofPhoneNumber.letterCombinations("234");
    }
}
