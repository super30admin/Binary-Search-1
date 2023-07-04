// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// For rotated sorted array atlest one side of the array is sorted, based on that assumption
// we check if the target is the mid or if the target lies in the first half or the second half
// binary search is performed on the sorted array.

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if( nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            else{
                if(target <= nums[high] && target > nums[mid]){
                    low = mid+1;
                }else{
                     high = mid-1;
                }
            }
        }
        return -1;
    }
}