package medium;

import java.util.Arrays;

/**
 * Share
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
//        if (nums.length == 0) {
//            return -1;
//        }
//        return search_in_(nums, target, 0, nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search_in_(int[] nums, int target, int start, int len) {
        int c_pos = len / 2;

        if (start + c_pos < 0 || start + c_pos >= nums.length) {
            return -1;
        }
        int center = nums[start + c_pos];
        int l_c_pos = start + c_pos / 2;
        if (l_c_pos < 0 || l_c_pos >= nums.length) {
            return -1;
        }
        int left_center = nums[l_c_pos];
        int r_c_pos = start + len - 1 - c_pos / 2;
        if (r_c_pos < 0 || r_c_pos >= nums.length) {
            return -1;
        }
        int right_center = nums[r_c_pos];
        if (center == target) {
            return start + c_pos;
        } else if (Math.abs(left_center - target) < Math.abs(right_center - target)) {
            return search_in_(nums, target, start, c_pos);

        } else {
            return search_in_(nums, target, start + c_pos + 1, start + len - 1 - (start + c_pos));
        }
    }


    public static void main(String[] args) {
        int[] nums = {
                3, 5, 1
        };
        SearchRotatedSortedArray_33 searchRotatedSortedArray33 = new SearchRotatedSortedArray_33();
        System.out.println(searchRotatedSortedArray33.search(nums, 6));
        ;
    }
}
