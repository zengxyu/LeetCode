package medium;

import java.util.ArrayList;

import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs("", 0, 0, n, results);
        return results;
    }

    public void dfs(String cur, int left, int right, int n, List<String> results) {
        if (left == n && right == n) {
            results.add(cur);
            return;
        }
        if (left < n) {
            dfs(cur + "(", left + 1, right, n, results);
        }
        if (right < n && left >= right) {
            dfs(cur + ")", left, right + 1, n, results);
        }
    }

    public static void main(String[] args) {

    }
}
