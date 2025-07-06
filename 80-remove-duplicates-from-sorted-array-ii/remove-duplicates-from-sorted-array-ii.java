class Solution {
    public int removeDuplicates(int[] a) {
        int i = 0;
        for (int n : a) {
            if (i < 2 || n != a[i - 2]) {
                a[i++] = n;
            }
        }
        return i;
    }
}
