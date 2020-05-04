import com.sun.org.apache.regexp.internal.RE;

/**
 * Program: LeetCode
 * Description: Given an array nums and a value val, remove all instances of that value in-place and return the new length.  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-04 15:18
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        {
            int count = 0;
            if (nums.length <= 0) {
                return nums.length;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != val) {
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                //如果当期元素等于给定值，那么该元素不符合给定规范，从后面元素中找一个不一样的替换当前元素
                if (nums[i] == val) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] != val) {
                            int a = nums[i];
                            nums[i] = nums[j];
                            nums[j] = a;
                            break;
                        }
                    }
                }
            }

            return count;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 2, 2, 3
        };
        RemoveElement removeElement = new RemoveElement();
        System.out.println("count = " + removeElement.removeElement(nums, 3));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
