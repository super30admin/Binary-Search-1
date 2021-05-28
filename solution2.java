// Time Complexity : O(log n) , all operations done in binary search so O(log n) 
// Space Complexity : O(1) no Data Struct used
// Did this code successfully run on Leetcode :i still need to run it on leetcode
// Any problem you faced while coding this :
// I think i got it to work in O(log n) and got correct results for my test case
// but i still need some time with this to test and debug some things.


// Your code here along with comments explaining your approach

public class solution2 {
	
	 public static int search(int[] nums, int target) {
		
	/*if nums array is undefined or empty*/	 
	if (nums == null || nums.length == 0) {
       System.out.println("null or empty array");
    }
	
	
	/*create a left && right counters for nums array */
    int left = 0;
    int right = nums.length - 1;
    
    /*
     * We need to find the pivot where the nums array breaks.
     * we go left from right and do a binary search to find the smallest element.
     * 
     * while loop iterate over the whole array until you find the pivot. */
    while (left < right) {
    	
    	/* (right-left) is done to prevent integer overflow*/
        int mid = left + (right-left) / 2;
        
        
        /*
         * if middle element> right most element this can
         * only happen when there is a rotation 
         * eg: 6,7,8,9,10,11,1,2,3,4,5 
         * here 11> 5 so pivot is on right 
         * so shift left to right next element of mid
         * else it is on left side 
         * so point right to mid from right most element
         * repeat while loop till you get pivot
         * */
        
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        }
        else if  (nums[mid] <= nums[right]){
            right = mid;
        }
	    }
    
    System.out.println("pivot is at " + left);
    
    int pivot = left;
	 /*
	  * separate them into two sides arrays
	  * at pivot
	  * 27,28,29
	  * 21,22,23,24,25,26
	  * 
	  * if target greater than 21 then use 21...26
	  * else use other 27...29
	  * */

    
    
    /*
     * NOt sure why but my left and right are both pointing to pivot
     * i think i need to reintialize right to right most? 
     * Note: ok that worked
     * */
    right = nums.length -1;
    		
    if (target < nums[pivot]){
    //goto left side of pivot
    	right = pivot;
    }
    
    //don't need else since left is already our pivot
    
    
    System.out.println("left is at " + left);
    System.out.println("right is at " + right);
    
/*do the standard binary search on the chosen side
 * */
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid; 
            
        } else if (target < nums[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
    	
}
	  

public static void main(String[] args) {
    	
    	int[] arr = {27,28,29,21,22,23,24,25,26};
    	System.out.println("the returned val is " + search(arr, 24));
    	
	
	
	}

}
