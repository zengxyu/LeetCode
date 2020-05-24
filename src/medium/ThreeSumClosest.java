package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原本要用三个循环，现在只需要用两个，
 * Time complexity : O(n^2)
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int closest_sum = nums[0] + nums[1] + nums[2];
        int min_diff = Math.abs(closest_sum - target);
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else return sum;
                    int diff = Math.abs(sum - target);
                    if (diff < min_diff) {
                        closest_sum = sum;
                        min_diff = diff;
                    }
                }
            }
        }
        return closest_sum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums = new int[]{0, 1, 2};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }
}
