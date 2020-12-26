/**

Leetcode problem 33 : Search in a rotated sorted array


Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : sometimes miss edge cases


Your code here along with comments explaining your approach



Collabedit: http://collabedit.com/buddf

**/
class Solution {

    public int search(int[] nums, int target) {
    
    final int NOT_FOUND = -1;
    
    if( nums == null || nums.length == 0) return NOT_FOUND;
    
    final int START = 0;
    final int END = nums.length -1;
    
    int low = START;
    int high = END;
    
    
    while ( low <= high ) {
        
        int mid = low + (high-low)/2;
        
        if( nums[mid] == target) return mid;
        
        if( nums[low] <= nums[mid] ) {
        
            // this mean that array from low to mid is a sorted array
            
            boolean targetLiesInLeftRange = target >= nums[low] && target < nums[mid];
            
            if ( targetLiesInLeftRange )
                high = mid -1;
            else
                low = mid + 1;
        
        
        }
        else
        {
            // right part of the mid is a sorted array
            
            boolean targetLiesInRightRange = target >nums[mid] && target <=nums[high];
            
            if ( targetLiesInRightRange )
                low = mid + 1;
            else
                high = mid - 1;
        
        }
        
    
    }
    
    return NOT_FOUND;
    
        
    }
}