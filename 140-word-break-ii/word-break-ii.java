import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                List<String> suffixRes = dfs(s.substring(i), dict, memo);
                for (String sub : suffixRes) {
                    res.add(prefix + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
