// Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class SearchInRotatedArray{
	public int search(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]) end = mid -1;
                else start  = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[end]) start = mid +1;
                else end = mid -1;
            }
            
        }
        
        return -1;
    }
}
