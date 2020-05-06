package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        char[] s_char_array = s.toCharArray();
        int i = 0;
        int sum = 0;
        while (i < s_char_array.length) {
            if (i + 1 < s_char_array.length) {
                char current = s_char_array[i];
                char next_current = s_char_array[i + 1];
                if (map.get(current) >= map.get(next_current)) {
                    sum = sum + map.get(current);
                    i = i + 1;
                } else {
                    int a = map.get(next_current) - map.get(current);
                    sum = sum + a;
                    i = i + 2;
                }
            } else {
                char current = s_char_array[i];
                sum = sum + map.get(current);
                i = i + 1;
            }

        }
        return sum;
    }
    public int romanToInt0(String s) {
        Map<Character, Integer> map = new HashMap();
        {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        char[] s_char_array = s.toCharArray();
        int i = 0;
        int sum = 0;
        char pre = 'a';
        while (i < s_char_array.length) {
            char current = s_char_array[i];
            sum = sum + map.get(current);
            if ((pre!='a' )&& (map.get(pre) < map.get(current))){
                sum = sum- 2*map.get(pre);
            }
            pre = current;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt0("LVIII"));
        ;


    }
}
