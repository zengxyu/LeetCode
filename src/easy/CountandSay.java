package easy;

/**
 * Program: LeetCode
 * Description: The count-and-say sequence is the sequence of integers with the first five terms as following:
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-04 16:22
 **/
public class CountandSay {
    public String countAndSay(int n) {
        String seq = "1";
        for (int j = 1; j < n; ++j) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = seq.charAt(0);
            int count = 1;
            for (int i = 1; i <seq.length();i++){
                if (seq.charAt(i) == c){
                    count++;
                }else {
                    stringBuilder.append(count);
                    stringBuilder.append(c);
                    c = seq.charAt(i);
                    count = 1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(c);
            seq = stringBuilder.toString();
        }
        return seq;
    }
    public static void main(String[] args) {
        CountandSay countandSay = new CountandSay();
        String a = countandSay.countAndSay(4);
        System.out.println(a);
    }
}
