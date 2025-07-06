import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] a) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : a) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = new String(c);
            m.computeIfAbsent(k, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(m.values());
    }
}
