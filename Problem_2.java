/* 

Problem 1: Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


Approach : Implemented using binary search and updated the low/high values by chosing the side that is sorted and then checking if
the target is within the range of that side. If not then we update the high/low values to the other side which is not sorted.

*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[high] >= target && nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
         
        }
        return -1;
    }
}