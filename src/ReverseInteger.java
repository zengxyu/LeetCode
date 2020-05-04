import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {
    public int reverse0(int x) {
        //最后一道题
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        int unsigned_x = sign * x;
        List<Integer> list = new ArrayList();
        int bit_num = String.valueOf(unsigned_x).length();
        for (int i = bit_num - 1; i >= 0; i--) {
            int bit = (int) Math.pow(10, i);
            int b = (int) unsigned_x / bit;
            unsigned_x = unsigned_x - bit * b;
            list.add(b);
        }
        Collections.reverse(list);
        long sum = 0;
        for (int i = 0; i < bit_num; i++) {
            long bit = (int) Math.pow(10, bit_num - i - 1);
            sum = sum + sign * bit * list.get(i);
        }
        int sum1 = (int) sum;
        if (String.valueOf(sum1).equals(String.valueOf(sum))) {
            return sum1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));

    }
}
