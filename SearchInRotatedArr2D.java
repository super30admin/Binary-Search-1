//TC: O(log n)
//SC: O(1)
class Solution {
    public int search(int[] nums, int target) {
        
        //null check
         // if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = (low + (high - low) / 2);
            
            if(nums[mid] == target) return mid; //this formula and not low+high / 2 bcz integer overflow will happen
            
            //if left side is sorted
            if(nums[low] <= nums[mid] ) {
                if(nums[low] <= target &&  target <= nums[mid]) {
                   high = mid - 1;
                } else {
                    low = mid + 1;
                }       
            } else { //if right side is sorted
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                
            }
            
        }
       
        return -1;
    }
}