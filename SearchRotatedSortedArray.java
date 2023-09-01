// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1037951446/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Use the binary search algorithm, to find the element in O(logn) time
 * Remember, whenever a sorted array is rotated then it has 2 parts one is sorted and other is unsorted 
 * Check the target is present in the sorted array if not check through the unsorted array
 */

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return -1;
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high-low)/2; //to prevent integer overflow
            if(nums[mid]== target)
                return mid;
            if(nums[low]<=nums[mid]){
                if( target >= nums[low] && target< nums[mid]){
                    high = mid-1;
                }
                else
                    low = mid+1;
            }
            else{
                if(target <= nums[high] && target > nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
