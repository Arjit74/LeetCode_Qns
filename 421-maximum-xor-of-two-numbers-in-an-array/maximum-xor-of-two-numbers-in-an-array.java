class Solution {
    static class Trie {
        class Node {
            Node zero;
            Node one;
        }
        Node root = new Node();
        public void add(int num) {
            Node curr = root;
            for(int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if(bit == 0) {
                    if(curr.zero == null) curr.zero = new Node();
                    curr = curr.zero;
                } else {
                    if(curr.one == null) curr.one = new Node();
                    curr = curr.one;
                }
            }
        }
        public int getMaxXor(int num) {
            Node curr = root;
            int ans = 0;
            for(int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if(bit == 0) {
                    if(curr.one != null) {
                        ans |= (1 << i);
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if(curr.zero != null) {
                        ans |= (1 << i);
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }
            return ans;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int i = 0; i < nums.length; i++) {
            t.add(nums[i]);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, t.getMaxXor(nums[i]));
        }
        return ans;
    }
}
