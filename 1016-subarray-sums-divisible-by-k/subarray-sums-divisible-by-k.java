import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));  // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderFreq = new HashMap<>();
        remainderFreq.put(0, 1); 
        int sum = 0; 
        int count = 0; 
        
        for (int num : nums) {
            sum += num; 
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }
            count += remainderFreq.getOrDefault(remainder, 0);
            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}