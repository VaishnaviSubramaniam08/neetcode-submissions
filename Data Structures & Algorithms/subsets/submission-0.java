class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums,new ArrayList<>());
        return result;
    }
    public void backtrack(int index,int[] nums,List<Integer> current){
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(index+1,nums,current);
        current.remove(current.size()-1);
        backtrack(index+1,nums,current);

    }
}
