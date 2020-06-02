package medium;

import java.util.*;

public class CombinationSumII_40 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        int index = -1;
        for (int i = candidates.length - 1; i >= 0; i--) {
            int item = candidates[i];
            if (item <= target) {
                index = i;
                break;
            }
        }
        dfs(candidates, index, target, new Stack<Integer>());
        return res;
    }

    public void dfs(int[] candidates, int index, int remain, Stack<Integer> stack) {
        if (remain == 0) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        if (remain < 0 || index < 0) {
            return;
        }
        //用hashSet来去掉相同子树
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = index; i >= 0; i--) {
            if (hashSet.add(candidates[i])) {
                //用stack不用一直 新建list
                stack.push(candidates[i]);
                int remain2 = remain - candidates[i];
                int index2 = i - 1;
                dfs(candidates, index2, remain2, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII_40 combinationSum = new CombinationSumII_40();
        int[] candidates = new int[]{
                10, 1, 2, 7, 6, 1, 5
        };
        int target = 8;
        combinationSum.combinationSum2(candidates, target);
        for (int i = 0; i < combinationSum.res.size(); ++i) {
            List<Integer> list = combinationSum.res.get(i);
            System.out.println();
            System.out.print('[');
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.print(']');

        }
    }

}
