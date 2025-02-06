class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Combination(candidates, target, ll, 0,ans);
        return ans;
}
    public static void Combination(int[] coin, int ammount,List<Integer> ll, int idx,List<List<Integer>> ans){
        if(ammount == 0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i = idx; i < coin.length;i++){
            if(ammount >= coin[i]){
                ll.add(coin[i]);
                Combination(coin, ammount-coin[i], ll, i,ans);
                ll.remove(ll.size()-1);
            }
        }
    }
}