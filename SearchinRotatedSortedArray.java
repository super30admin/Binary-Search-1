//time complexity: O(logn)
//space complexity: O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int search(int[] nums, int target) {
        
        //checking if array is empty
        if(nums.length == 0 || nums == null) return -1; 
        int low = 0;
        int high = nums.length -1; 
        
        while(low <=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid] == target) return mid;
            
            
            else if(nums[low] <= nums[mid]){
                //checking if the left array is sorted
                if(nums[low] <= target && nums[mid] >target){
                    high = mid-1;
                 }else {
                    low = mid +1;
                }  
            }
            else 
                //checking if right array is sorted
                if(nums[mid] <target && nums[high] >=target){
                    low = mid+1;
                }else {
                    high = mid -1; 
                }             
        }
        return -1; //if did not find the element returning -1
        
    }
}