package medium;

import java.util.Arrays;

public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place and use only constant extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * <p>
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * @param nums
     */
    // 数组的排列组合中，比当前排列大的下一个排列如何找到?
    // 从后往前遍历，如[1,3,4,2],前面的数一定比后面的数大，当找到一个前面的数比后面的数小，如3, 3后面的数中选一个比3大的数和3交换，就可以得到一个比当前排列大的排列
    // 故[1,4,3,2],[1,4,2,3]都比当前排列大
    // 从3后面的数中选一个比3大的最小的数，与3交换。
    // 再把原3所在位置后面的数组从小到大排列，就可得到符合题意的比当前排列大的下一个排列

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        boolean flag = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = true;
                int start = i - 1;
                int min_remain = Integer.MAX_VALUE;
                int min_remain_pos = start;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[start] && nums[j] < min_remain) {
                        min_remain = nums[j];
                        min_remain_pos = j;
                    }
                }

                int temp = nums[start];
                nums[start] = nums[min_remain_pos];
                nums[min_remain_pos] = temp;
                for (int k = i; k < nums.length - 1; k++)
                    for (int m = i; m < nums.length - 1; m++)
                        if (nums[m + 1] < nums[m]) {
                            int temp2 = nums[m + 1];
                            nums[m + 1] = nums[m];
                            nums[m] = temp2;
                        }
                break;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
        }

    }

    public static void main(String[] args) {
        int[] nums = {
                2, 3, 1
        };
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
