/**
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

Time Complexity : O(M) + O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : NO
    
Collabedit: http://collabedit.com/g8p3a

**/

class SearchInRotatedSortedArray 
{
	public int search(int[] nums, int target) {
        
    final int START = 0;
    final int END = nums.length -1;
    final int NOT_FOUND = -1;


    int low = START;
    int high = END;
        
    while ( low <= high ) {
        
        
        int mid = low + (high-low)/2;
        // now at any mid of the rotated sorted array, either of the two side on the mid
        // should always be sorted
        
        
        if( nums[mid] == target )
            return mid;
        else {
        
            boolean isLeftSideSorted = mid == START || nums[low] <= nums[mid -1];
            
            if( isLeftSideSorted)
            {
                // check if the target lies in the sorted range 
                boolean targetLiesOnLeft = mid != START && target >= nums[low] && target <= nums[mid-1] && mid!= low;
                
                if(targetLiesOnLeft) 
                    high = mid -1;
                else
                    low = mid + 1;
            }
            else
            {
                // now the array to the right side of mid is sorted
                
                boolean targetLiesOnRight = mid != END && target >=nums[mid+1] && target <= nums[high] && mid!=high;
                
                if(targetLiesOnRight)
                    low = mid + 1;
                else
                    high = mid -1;
            }
        
        }
    
    }
    
    return NOT_FOUND;
        
    
        
    }
}