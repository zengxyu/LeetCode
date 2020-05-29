package medium;

public class FindFirstLastPositionofElement_34 {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left < right) {
            int center = left + (right - left) / 2;
            if (nums[center] == target) {
                index = center;
                break;
            } else if (target < nums[center]) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        int low = index;
        int high = index;
        while (low - 1 >= 0 && nums[low - 1] == target) {
            low--;
        }
        while (high + 1 <= nums.length - 1 && nums[high + 1] == target) {
            high++;
        }
        ;
        return new int[]{low, high};
    }

    public static void main(String[] args) {

    }
}
