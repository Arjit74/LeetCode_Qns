class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipParts = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        int index = 0;
        solve(s, ipParts, answer, index);
        return answer;
    }

    void solve(String s, List<String> currentIpParts, List<String> answer, int index) {
        if (currentIpParts.size() == 4) {
            if (index == s.length()) {
                answer.add(String.join(".", currentIpParts));
            }
            return;
        }

        if (currentIpParts.size() > 4 || index == s.length()) {
             return;
        }

        for (int i = index + 1; i <= Math.min(index + 3, s.length()); i++) {
            String nextSegment = s.substring(index, i);

            if (isValidSegment(nextSegment)) {
                currentIpParts.add(nextSegment);
                solve(s, currentIpParts, answer, i);
                currentIpParts.remove(currentIpParts.size() - 1);
            }
        }
    }

    private boolean isValidSegment(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}