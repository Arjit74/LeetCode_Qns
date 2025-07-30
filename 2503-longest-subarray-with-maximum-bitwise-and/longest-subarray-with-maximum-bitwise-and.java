class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num:nums){
            if(num>max){
                max = num;
            }
        }
        int count = 0, longest = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 0;
            }
        }
        return longest;
        
    }
}