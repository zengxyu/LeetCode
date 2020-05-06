package easy;

public class Palindrome {
    public boolean isPalindrome(int x) {
//        int sign = 1;
//        if (x < 0) {
//            sign = -1;
//        }
//        int unsigned = sign * x;
        String unsigned_s = String.valueOf(x);
        char[] c_array = unsigned_s.toCharArray();
        int length = unsigned_s.length();
        for (int i = 0; i < length/2; i++) {
            if (c_array[i] != c_array[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(10));;
    }
}
