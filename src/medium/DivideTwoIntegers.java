package medium;

import java.security.UnrecoverableEntryException;
import java.util.*;

public class DivideTwoIntegers {
    public int divide1(int dividend, int divisor) {
        int sign = -1;
        long dividend2 = dividend;
        long divisor2 = divisor;
        if ((dividend2 < 0 && divisor2 < 0) || (dividend2 > 0 && divisor2 > 0)) {
            sign = 1;
        }
        dividend2 = Math.abs(dividend2);
        divisor2 = Math.abs(divisor2);
        List<Long> sumList = new ArrayList<>();
        List<Long> countList = new ArrayList<>();
        long sum = divisor2;
        long count = 1;
        if (sum <= dividend2) {
            sumList.add(sum);
            countList.add(count);
        }
        while (sum < dividend2) {
            sum += sum;
            count += count;
            sumList.add(sum);
            countList.add(count);
        }
        long c = 0;
        for (int i = countList.size() - 1; i >= 0; i--) {
            if (sumList.get(i) <= dividend2) {
                c += countList.get(i);
                dividend2 -= sumList.get(i);
            } else {
                continue;
            }
            if (dividend2 < divisor) {
                break;
            }
        }
        if (sign > 0) {
            if (c == Integer.MIN_VALUE) {
                System.out.println(c);
                return Integer.MAX_VALUE;
            } else if (c == (long) Integer.MAX_VALUE + 1) {
                System.out.println(c);
                return Integer.MAX_VALUE;
            } else
                System.out.println(c);
                return (int) c;
        } else {
            if (c == Integer.MIN_VALUE) {
                System.out.println(c);
                return Integer.MIN_VALUE;
            } else if (c == Integer.MAX_VALUE) {
                System.out.println(c);
                return Integer.MAX_VALUE;
            } else
                System.out.println(c);
                return (int) -c;
        }

    }



    public static void main(String[] args) {
        int dividend = 1;
        int divisor = 1;
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        divideTwoIntegers.divide1(dividend, divisor);
    }
}
