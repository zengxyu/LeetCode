package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations_46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        dfs(list, new ArrayList<>());
        return res;
    }
    // recursive 递归
    public void dfs(List<Integer> list, List<Integer> list2) {
        if (list.size() > 0) {
            for (int i = list.size() - 1; i >= 0 ; i--) {
                // 把这个数加入到new_list2中，每次加入的一个数，都是一个新的分支，所以要创建一个new_list2
                List<Integer> new_list2 = new ArrayList<>(list2);
                new_list2.add(list.get(i));
                // 删除该数，但不能循环一次删一个，每次都是从list中删，所以每次要新建一个new_list1
                List<Integer> new_list1 = new ArrayList<>(list);
                new_list1.remove(i);
                dfs(new_list1, new_list2);
            }
        } else {
            res.add(list2);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permutations_46 permutations = new Permutations_46();
        permutations.permute(nums);
    }
}
