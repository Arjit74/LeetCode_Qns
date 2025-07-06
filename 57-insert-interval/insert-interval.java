import java.util.*;

class Solution {
    public int[][] insert(int[][] a, int[] ni) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = a.length;

        while (i < n && a[i][1] < ni[0]) res.add(a[i++]);

        while (i < n && a[i][0] <= ni[1]) {
            ni[0] = Math.min(ni[0], a[i][0]);
            ni[1] = Math.max(ni[1], a[i][1]);
            i++;
        }
        res.add(ni);

        while (i < n) res.add(a[i++]);

        return res.toArray(new int[res.size()][]);
    }
}
