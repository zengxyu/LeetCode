package medium;

/**
 * Program: LeetCode
 * Description: Implement atoi which converts a string to an integer.  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.  If no valid conversion could be performed, a zero value is returned.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-10 21:07
 **/
public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.equals("")){
            return 0;
        }
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            sign = 1;
            str = str.substring(1);
        } else if (Character.isDigit(str.charAt(0))) {
            sign = 1;
        } else {
            return 0;
        }
        //判断，如果是数字，就加入到 StringBuilder里
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        String temp = sb.toString();
        int sum = 0;
        System.out.println("temp = " + temp);
        for (int i = 0; i < temp.length(); i++) {
            int digit = temp.charAt(i) - '0';
            if (sign ==1){
                // 如果是正数
                if (sum <= (Integer.MAX_VALUE - sign * digit) / 10.0){
                    //未超过边界
                    sum = sum * 10 + sign * digit;
                }else {
                    //超过边界
                    return Integer.MAX_VALUE;
                }
            }
            else {
                //如果是负数
                if (sum >= (Integer.MIN_VALUE - sign * digit) / 10.0){
                    //未超过边界
                    sum = sum * 10 + sign * digit;
                }else
                    //超过边界
                    return Integer.MIN_VALUE;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringtoInteger stringtoInteger = new StringtoInteger();
//        String s = "4193 with words";
        String s = "4193 with words";
//        String s = "+";
        System.out.println(stringtoInteger.myAtoi(s));
    }
}
