class Solution {
    public void sortColors(int[] a) {
        int l = 0, r = a.length - 1, i = 0;
        while (i <= r) {
            if (a[i] == 0) {
                swap(a, i++, l++);
            } else if (a[i] == 2) {
                swap(a, i, r--);
            } else {
                i++;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
