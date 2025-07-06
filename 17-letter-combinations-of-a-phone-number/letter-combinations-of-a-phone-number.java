import java.util.*;

class Solution {
    public List<String> letterCombinations(String d) {
        if (d == null || d.length() == 0) return new ArrayList<>();
        String[] m = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        dfs(d, 0, new StringBuilder(), res, m);
        return res;
    }

    void dfs(String d, int i, StringBuilder sb, List<String> res, String[] m) {
        if (i == d.length()) {
            res.add(sb.toString());
            return;
        }
        String chars = m[d.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            sb.append(c);
            dfs(d, i + 1, sb, res, m);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
