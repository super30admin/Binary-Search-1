// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Trying to comprehend how to find the pivot.
// I also didn't read the question well and was just returning the mid while
// the question had asked to return the newIndexmid.

// Your code here along with comments explaining your approach
// Find the Pivot(smallest element in the array, around which the array has been rotated)
// Then use the index of the pivot to find the target as if the array was never rotated
// This was achieve using "int midNewIndex = (mid+pivot)%len;"
class Solution {
    public int findPivot(int[] nums){
        int low = 0;
        int len = nums.length;
        int high = len-1;
        int ans = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]<=nums[len-1]){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int pivot = findPivot(nums);
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int midNewIndex = (mid+pivot)%len;
            if(nums[midNewIndex]<target){
                low = mid+1;
            }
            else if(nums[midNewIndex]>target){
                high = mid-1;
            }
            else{
                return midNewIndex;
            }
        }
        return -1;
    }
}
