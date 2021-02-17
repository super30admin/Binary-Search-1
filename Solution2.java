class Solution2 {
    public int search(int[] nums, int target) {
        int candidate =-1;
        if(nums.length == 0)
            return candidate;
        
        int prev=nums[0];
        if(prev == target)
            return 0;
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == target){
                candidate = i;
            }
            
        }
        return candidate;
        
    }
}
