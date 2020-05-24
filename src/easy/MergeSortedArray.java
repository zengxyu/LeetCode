package easy;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray {
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            int min = nums1[i];
            int min_index = i;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[j] < min) {
                    min = nums1[j];
                    min_index = j;
                }
            }
            int swap = nums1[i];
            nums1[i] = nums1[min_index];
            nums1[min_index] = swap;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{
                1, 2, 3, 0, 0, 0
        };
        int[] num2 = new int[]{2, 5, 6};
        mergeSortedArray.merge(nums1, 3, num2, 3);
    }
}
