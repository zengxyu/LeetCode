package easy;

/**
 * Program: LeetCode
 * Description: Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-04 16:05
 **/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {
                1, 3, 5, 6};
        int target = 7;
        SearchInsertPosition searchInsert = new SearchInsertPosition();
        System.out.println(searchInsert.searchInsert(nums, target));
    }
}
