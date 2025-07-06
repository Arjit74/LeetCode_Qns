class Solution {
    public String longestCommonPrefix(String[] a) {
        if (a == null || a.length == 0) return "";
        String p = a[0];
        for (int i = 1; i < a.length; i++) {
            while (!a[i].startsWith(p)) {
                p = p.substring(0, p.length() - 1);
                if (p.isEmpty()) return "";
            }
        }
        return p;
    }
}
