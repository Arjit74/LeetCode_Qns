import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        back(0, a, new ArrayList<>(), res);
        return res;
    }

    void back(int i, int[] a, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            path.add(a[j]);
            back(j + 1, a, path, res);
            path.remove(path.size() - 1);
        }
    }
}
