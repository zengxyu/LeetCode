package easy;

/**
 * Program: LeetCode
 * Description: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-04 14:11
 **/
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        if (nums.length <= 1) {
            return nums.length;
        }
        int pre_num = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != pre_num) {
                count++;
                pre_num = nums[i];
            }
        }
        int save = 0;
        for (int i = 0; i < count - 1; i++) {
            //如果num[i+1] <= num[i+1], 说明后面那个数不符合规则，需要替换掉，�?�么替换�?? 从num[i+1]�?后找�?个比num[i]大的数来替换
            if (nums[i + 1] <= nums[i]) {
                for (int j = save + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        int a = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = a;
                        save = j;
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        System.out.println(removeDuplicatesfromSortedArray.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
