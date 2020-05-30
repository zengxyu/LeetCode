package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 */
public class PermutationsII_47 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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
            List<Integer> temp = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0 ; i--) {
                if (!temp.contains(list.get(i))){
                    temp.add(list.get(i));
                    // 把这个数加入到new_list2中，每次加入的一个数，都是一个新的分支，所以要创建一个new_list2
                    List<Integer> new_list2 = new ArrayList<>(list2);
                    new_list2.add(list.get(i));
                    // 删除该数，但不能循环一次删一个，每次都是从list中删，所以每次要新建一个new_list1
                    List<Integer> new_list1 = new ArrayList<>(list);
                    new_list1.remove(i);
                    dfs(new_list1, new_list2);
                }
            }
        } else {
            res.add(list2);
        }
    }
    public static void main(String[] args) {

    }
}
