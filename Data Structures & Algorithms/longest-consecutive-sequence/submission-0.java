class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxi=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int curr=num;
                int len=1;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }

            
            maxi=Math.max(len,maxi);
            }
        }
        return maxi;
    }
}
