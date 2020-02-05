// Time Complexity : O(log N) where N is size of the array
// Space Complexity : O(1) auxillary space as we haven't used additional space for the logic
// Did this code successfully run on Leetcode : Ran it on leetcode playground
// Any problem you faced while coding this : Because I took a finite array test-case, if I was searching for element in the end of array
//, threw ArrayIndexOutOfBoundsException as high*2 index is not available. (2340 for example)


// Your code here along with comments explaining your approach
/*
1. As array is sorted, we need to perform binary search here. 
2. To do so, we need to first find upper and lower bounds where target is present.
3. Once low and high are found, perform binary search for target. 
*/


public class InfiniteSortedArraySearch {
    
    private static int search(int[] nums, int target) {
        int low = 0, high = 1;
        // Find the upper and lower bounds for search - high and low
        while(nums[high] < target ) {
            low = high;
            high = high*2;
        }
        
        // Find target with binary search
        while(low <= high ) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,6,7,9,10,34,65,78,99,103,340,569,655,898,901,1023,2340,5606};
        
        System.out.println("Search result for 103 "+search(nums,103));
        
    }
}