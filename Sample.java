//Problem-1
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int low = 0; // intialized low to start of array
        int high = nums.length -1; // initialized high to end of array
     
        while(low<=high) // till low doesn't cross high
        {
            int mid = low + (high - low) /2; // finding mid index for each iteration
            if(nums[mid] == target) // if target found at mid 
                return mid; // return the index at which target found
           else if(nums[mid] <= nums[high]) // to check if the upper half of the array is sorted or not
            { // if sorted
                if(nums[mid] <= target && nums[high] >= target) // check if target lies in the range
                    low = mid+1; // if it does, update the lower bound
                else
                    high = mid-1; // else update the higher bound
            }
            else // if first half is sorted
            {
                if(nums[low] <= target && nums[mid] >= target) // check if target lies in the range
                    high = mid-1; // if it does, update the higher bound
                else
                    low = mid+1; // else update the lower bound
                
            }
        }
      return -1;   // if not found return -1
    }

 }


//Problem-2
// Time Complexity :O(log t)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Unaware of how to approach the problem


// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; // intialized low to start of array
        int high = 1; // initialized high to end of array
        
        while(reader.get(high) < target) // till we reach the value where target exceeds the higher bound (to get the range where target will lie)
        {
            low = high; // recompute low to high
            high = high * 2; // increment high by twice the size to readjust the bounds
        }
        
        while(low<=high) // till low doesn't cross high
        {
            int mid = low + (high - low)/2; // finding mid index for each iteration
            
            if(reader.get(mid)== target) // if target found at mid 
                return mid; // return the index at which target found
            else if(reader.get(mid) > target) // if mid value is greater than the target
            {
                high = mid - 1; // update the higher bound as value lies in lower half
            }
            else
            {
                low = mid + 1; // else update the lower bound as value lies in upper half
            }
        }
        return -1;
        
    }
}