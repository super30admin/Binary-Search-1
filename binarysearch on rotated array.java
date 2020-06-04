// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : deciding the logic 


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
// most imp loop 
        while(start <= end){
        int mid = start + (end -start) / 2;
        if(nums[mid]==target) return mid;
//      if the first part of the array is sorted and is greater than the second part
        else if(nums[mid] >= nums[start]){
// if the target lies in the first part
            if(target >= nums[start] && target <= nums[mid]) end = mid-1;
// if the target lies in the second part
            else start = mid+1;
        }
        else {
//  if the second part of the array is smaller than the first part and is sorted
            if(target <= nums[end] && target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        }
        return -1;
    }
}
