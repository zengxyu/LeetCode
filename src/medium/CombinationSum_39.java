package medium;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 */
public class CombinationSum_39 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //列出所有小于7的排列组合
        Arrays.sort(candidates);
        int index = -1;
        for (int i = candidates.length - 1; i >= 0; i--) {
            int item = candidates[i];
            if (item <= target) {
                index = i;
                break;
            }
        }
        combinationTree(candidates, index, target, new ArrayList<>());
        return res;
    }

    public void combinationTree(int[] candidates, int index, int remain, List<Integer> list) {
        if (index < 0) {
            return;
        }
        //不考虑candidates[index]
        combinationTree(candidates, index - 1, remain, new ArrayList<>(list));
        //考虑candidates[index]
        int remain2 = remain - candidates[index];
        list.add(candidates[index]);
        if (remain2 == 0) {
            res.add(list);
        } else if (remain2 < 0) {

        } else {
            combinationTree(candidates, index, remain2, new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 combinationSum = new CombinationSum_39();
        int[] candidates = new int[]{
                10,1,2,7,6,1,5
        };
        int target = 8;
        combinationSum.combinationSum(candidates, target);
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
