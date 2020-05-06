/**
 * Program: LeetCode
 * Description: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 14:00
 **/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max_sum) {
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }

    public static int maxSubArray2(int[] nums) {

        int max_sum = nums[0];
        int current_sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (current_sum <= 0) {
                current_sum = nums[i];
            } else {
                current_sum += nums[i];
            }
            if (current_sum > max_sum) {
                max_sum = current_sum;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] nums = {
                -1, 0, -2
        };
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums)
        );
    }
}
