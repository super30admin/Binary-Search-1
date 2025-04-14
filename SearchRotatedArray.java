class SearchRotatedArray {
	/**Binary Search| Time O(log n) | Space O(1)**/
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;       
        
        while(low <= high) {
        	int mid= low + (high-low)/2;
        	
	        if(target == nums[mid]) {
	        	return mid;
	        }else if(nums[mid] >= nums[low]) {
	        	if(target >= nums[low] && target < nums[mid])
	        		high=mid-1;
	        	else
	        		low=mid+1;
	        }else {
	        	if(target <= nums[high] && target > nums[mid])
	        		low=mid+1;
	        	else
	        		high=mid-1;
	        }
        }
        
        return -1;
    }
}
