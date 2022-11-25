class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1 ;
        int mid = 0;
        while(low <= high){
            
            
            mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            
  
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <=nums[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            
            
            else{
            if(nums[mid + 1] <= nums[high]){
                if(target >= nums[mid + 1] && target <=nums[high])
                {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
    
            }
            
            
            
                    }
        return -1;
    }
}

// Given the rotated sorted array, at least one side of the array will be sorted
// Using Binary Search to divide half and search for the target
//TC = O(logn) because of biinary search
//SC = O(1) bcz of no extra space