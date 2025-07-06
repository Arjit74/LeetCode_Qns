class Solution {
    public boolean canJump(int[] a) {
        int far = 0;
        for (int i = 0; i <= far; i++) {
            far = Math.max(far, i + a[i]);
            if (far >= a.length - 1) return true;
        }
        return false;
    }
}
