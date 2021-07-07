/*optimized solution the trick is to not look for pivot(MAX Element whcih i was doing before and at any middle there is always sorted list either left or right
  Rotating list multiple time is the intuition*/

//Time Complexity = O(logN)
//Space Complexity = O(N)
//Leet Code run    = Yes

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
         } 
        //Iterative way
       
        int l = 0;
        int r = nums.length -1;
        
        //Base case
        while(l <= r){
            
            int mid = (l + (r-l)/2);
            
            //truth condition
            if(nums[mid] == target)
                return mid;
        
            //check if left part is sorted    
            else if(nums[l] <= nums[mid]){
                    if(nums[mid] >= target && target >= nums[l]){
                        r = mid;
                    }else{
                        l = mid + 1;
                    }
            }else{
                if(nums[mid] <= target && target <= nums[r]){
                        l = mid;
                    }else{
                        r = mid - 1;
                    }
            }
        
        }
        return -1;
        //return binary_search(nums,0,nums.length-1,target);   
    }
}
