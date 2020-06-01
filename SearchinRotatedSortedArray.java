class Solution {
    public int search(int[] nums, int target) {
       
        if(nums.length==0) return -1;
        
        int low = 0;
        int high = nums.length -1;
        
        while(low<= high){
      
             return binarySearch(nums, target,low,high);
         }   
            
        return -1;
    }

    private int binarySearch(int [] nums,int target,int low,int high){
        int mid = low + (high-low)/2;
        // base case
        if(low>high) return -1;  // if not sorted array dont do binary search
        
        if(nums[mid] == target) return mid;
        else if(nums[low] <=nums[mid]){ //look into left sorted array
            if(nums[low] <= target && nums[mid] >target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        else{//look into right sorted array
            if(nums[mid]< target && nums[high] >= target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
         return binarySearch(nums, target,low,high);
    }

}
/*
TimeComplexity O(logn)
SpaceComplexity O(n)  n recursive steps    
*/