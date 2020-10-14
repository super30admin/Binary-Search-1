package Day2;

class SearchElemRotatedSortedArr {
	
	// Time Complexity: O(log n)
    // Since we are doing binary search by reducing search space by half.
    
    // Space Complexity: O(1) 
    // No extra space used.
   
    // Did this code successfully run on Leetcode : Yes
    
    // Any problem you faced while coding this : 
	// I was using pivot method earlier for this question, so this approach discussed in class was new to me.
	// Doing it in code myself helped to clarify it better.
	
    public int search(int[] nums, int target) {
        
        // edge conditions
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // left part of array is sorted
            if (nums[start] <= nums[mid]) {
                // check if target lies in the left sorted part of the array
                // if yes, reset target search range from start to (mid-1)
                // if no, reset target search range from (mid+1) to end
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }   
            }
            // right part of array is sorted
            if (nums[mid] <= nums[end]) {
                 // check if target lies in the right sorted part of the array
                 // if yes, reset target search range from (mid+1) to end
                // if no, reset target search range from start to (mid-1)
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                } 
            }
        }
        
        return -1;
}
}