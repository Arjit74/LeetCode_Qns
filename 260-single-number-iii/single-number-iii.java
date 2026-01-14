class Solution {
    public int[] singleNumber(int[] nums) {
        return XOR(nums);
    }
    public int[] XOR(int[] nums){
        int xor = 0;
        for(int num:nums){
            xor ^=num;
        }
        int mask = (xor&(-1*xor));
        int a = 0;
        for(int i = 0; i<nums.length; i++){
            if((mask & nums[i])!=0){
                a^=nums[i];
            }
        }
        int b = xor^a;
        return new int[] {a,b};
    }
}