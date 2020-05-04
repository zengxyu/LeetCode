/**
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            for (int j = 0; j < len; j++) {
                if (i != j && diff == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum.twoSum(input, target)[0]);
        System.out.println(twoSum.twoSum(input, target)[1]);
    }

}
