//Time Complexity :O(logN) 

//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 

public class SearchInRotatedSortedArray {
	
	    public int search(int[] nums, int target) {
	        int low = 0;
	        int high = nums.length -1;

	        while(low<=high)
	        {
	            int mid = low + (high-low)/2;
	          // Left side sorted 
	          if(nums[mid]==target)
	                 return mid;

	         if(nums[low] <= nums[mid]){
	            if(nums[low]<=target && target < nums[mid]){
	                high = mid-1;
	            }
	            else{
	                low = mid+1;
	            }
	         }else{
	             if(nums[mid]< target && target <= nums[high]){
	                    low= mid+1;
	             }
	             else{
	                 high= mid-1;
	             }
	         }
	          


	        }
	        return -1;
	    }

	   
	}

