import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(n, 0, 0, "", res);
        return res;
    }

    void gen(int n, int o, int c, String s, List<String> res) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (o < n) gen(n, o + 1, c, s + "(", res);
        if (c < o) gen(n, o, c + 1, s + ")", res);
    }
}
