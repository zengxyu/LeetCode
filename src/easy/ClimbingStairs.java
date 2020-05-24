package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    static Map<Integer, Integer> map = new HashMap<> ();
    public int climbStairs(int n) {
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n <= 1){
            return 1;
        }else {
            int temp = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n,temp);
            return temp;
        }
    }

    public static void main(String[] args) {
        ClimbingStairs climbStairs = new ClimbingStairs();
        System.out.println(climbStairs.climbStairs(8));
    }
}
