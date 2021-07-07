class Solution1 {
    // Time :  O(logn)  Space : O(1)
    public int search(int[] nums, int target) {
        
        return search(nums, target, 0, nums.length-1);
    }
    
    public int search(int[] nums, int target, int l , int r){
        
       if(l > r){
            return -1;
        }
        int mid = (l+r)/2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(nums[l] <= nums[mid]){
            if (target >= nums[l] && target <= nums[mid]) 
                return search(nums, target, l, mid - 1); 
            
            
            return search(nums,target , mid+1 , r);
        }
        
        if(target >= nums[mid] && target <= nums[r]){
            return search(nums, target, mid+1 ,r);
        }
        return search(nums, target , l ,mid-1);
            
      
}
}