class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    void backtrack(int[] nums,int target,int start,List<Integer> curr,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            if(nums[i]>target)break;
            curr.add(nums[i]);
            backtrack(nums,target-nums[i],i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}