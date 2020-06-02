package medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        return index_reachable(nums, nums.length - 1);
    }

    public boolean index_reachable(int[] nums, int index) {
        if (index == 0) {
            // 可达
            return true;
        }
        //从index往前遍历，如果前面的元素可达该元素，则跳到那个元素
        for (int i = index - 1; i >= 0; i--) {
            int item = nums[i];
            if (item >= index - i) {
                return index_reachable(nums, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
