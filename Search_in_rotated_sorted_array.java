
public class Search_in_rotated_sorted_array {
     public int search(int[] nums, int target) {
    	 
    	 //  checking edge cases
    	 if(nums == null || nums.length == 0) {
    		 return -1;
    	 }
    	 
    	 int minIdx = findMinIdx(nums), left, right;
    	 
    	    if (target == nums[minIdx]) { 
    	    	return minIdx;
    	    }
    	    int len = nums.length - 1;
    	    
    	    // setting the value of left index to min index based on the target 
    	    if (target <= nums[len]) {
    	    	left = minIdx;
    	    }
    	    else left = 0;
    	    
    	    // setting the value of right index to min index based on the target
    	    if (target > nums[len]) {
    	    	right = minIdx;
    	    }
    	    else right = len;
    	    
    	    // normal binary search algorithm
    	    while (left <= right) {
    	        int mid = left + (right - left) / 2;
    	        if (nums[mid] == target) {
    	        	return mid;
    	        }
    	        else if (target > nums[mid]) {
    	        	left = mid + 1;
    	        }
    	        else {
    	        	right = mid - 1;
    	        }
    	    }
    	    return -1;
    	}

     // method to find the index of minimum number in the array
    	public int findMinIdx(int[] nums) {
    	    int left = 0, right = nums.length - 1;
    	    while (left < right) {
    	        int mid = left + (right -  left) / 2;
    	        if (nums[mid] > nums[right]) {
    	        	left = mid + 1;
    	        }
    	        else {
    	        	right = mid;
    	        }
    	    }
    		return left;
     }
    	
    	public static void main(String[] args) {
    		int nums[] = {4,5,6,7, 0,1,2}; 
    		//int nums[] = {0,1,2,4,5,6,7}; //sorted array.
    		Search_in_rotated_sorted_array arr= new Search_in_rotated_sorted_array();
    		System.out.println(arr.search(nums, 7));
    	}
}
