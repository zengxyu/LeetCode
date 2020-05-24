package medium;

import java.util.HashMap;

import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        int[] ns = new int[]{1000, 900, 500, 400,100, 90, 50,40, 10,9, 5, 4, 1};
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400,"CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num>0){
            for (int i = index; i < ns.length; i++) {
                int n = ns[i];
                if (num >= n) {
                    index = i;
                    sb.append(map.get(n));
                    num -=n;
                    break;
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        int num = 20;
        IntegertoRoman integer = new IntegertoRoman();
        System.out.println(integer.intToRoman(num));
    }
}
