import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1, cur = n;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
