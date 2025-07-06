import java.util.*;

class FindSumPairs {
    int[] nums1, nums2;
    Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freqMap = new HashMap<>();
        for (int n : nums2) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) freqMap.remove(oldVal);

        nums2[index] += val;
        freqMap.put(nums2[index], freqMap.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int n1 : nums1) {
            int needed = tot - n1;
            count += freqMap.getOrDefault(needed, 0);
        }
        return count;
    }
}
