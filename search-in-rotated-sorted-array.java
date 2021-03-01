class Solution {
    public int search(int[] nums, int target) {
        
        /*
        [4,5,6,0,1,2] search(2)
        */
        //define pointers
        int low = 0; //0
        int high = nums.length - 1; // 5
        
        while(low <= high){
        int mid = low + (high - low)/2 ; // 2
        if(nums [mid] == target) return mid ; 
        // checking if left part of array is sorted
        if(nums [mid] >= nums [low]){ //sorted
            if(nums [low] <= target && nums [mid] >= target){
                // low <= target <= mid
                
                high = mid - 1;
            }
            else{
            low = mid + 1;
                
            }
        }
        //if right array is sorted
        else {
            if(nums [high] >= target && nums [mid] <= target){ 
                //   mid <= target <= high
                low = mid + 1;
            }
            else{
            high = mid - 1;
                
            } 
            
        }
        
    
    }
    return -1;
    
    }
}