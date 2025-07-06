class Solution {
    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];

                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
