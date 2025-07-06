class Solution {
    public int removeDuplicates(int[] a) {
        int i = 0;
        for (int n : a) {
            if (i == 0 || n != a[i - 1]) a[i++] = n;
        }
        return i;
    }
}
