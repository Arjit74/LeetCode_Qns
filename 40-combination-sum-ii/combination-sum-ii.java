import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, temp, result); 
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution cs = new Solution();

        // Example 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(cs.combinationSum2(candidates1, target1)); // Output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        // Example 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(cs.combinationSum2(candidates2, target2)); // Output: [[1, 2, 2], [5]]
    }
}
