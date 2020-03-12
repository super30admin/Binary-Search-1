//33.Search in rotated array
// Time Complexity : O(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
	
	// Find the starting point of sorted array
        int low = 0;
        int len = nums.length;
        int high = len - 1;
        
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
	// Find target element using binary search
        int start = low;
        low = 0;
        high = len -1;
        while(low <= high){
            int mid = (low + high)/2;
            int mid1 = (mid + start) % len;
            
            if(nums[mid1] == target){
                return mid1;
            } else if(nums[mid1] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}