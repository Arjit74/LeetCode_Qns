import java.util.*;

class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();

        int[] cur = a[0];
        for (int i = 1; i < a.length; i++) {
            if (cur[1] >= a[i][0]) {
                cur[1] = Math.max(cur[1], a[i][1]);
            } else {
                res.add(cur);
                cur = a[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
