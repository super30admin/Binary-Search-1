// Time Complexity : As we are discarding half of the array each time and performing binary search only on rest half, this is O(log(n))
// Space Complexity : we have only taken a mid variable additionally, costing O(1) space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : went in too much complicacy at first trying to handle each case with condition, got to understand we just need to handle sorted array as it is and for unsorted find mid and check again untill sorted half remains or number is found

// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
        
    // Approach is to find middle element and if it is greater than or equal to low element
    // then all the elements to the left of middle are already sorted
    // similarly if middle element is less than low element then all the elements to the right
    // of mid are sorted
    public int binarySearch(int[] nums, int l, int h, int target) {
        // identified mid point of array
        int mid = (l+h)/2;
        if(target == nums[mid]) {
            return mid;
        }
        // if low index is greater than high return -1
        if(l>h) {
            return -1;
        }
        // for left sorted array
        if(nums[mid]>=nums[l]){
            // if target falls in sorted half, make binary search from l to mid-1 till target is found
            if(target>=nums[l] && target<=nums[mid]){
                return binarySearch(nums, l, mid-1, target);
            }
            // else make a binary search in right half
            else{
                return binarySearch(nums, mid+1, h, target);
            }
        } else {
            // if target falls in sorted half, make binary search from mid+1 to h till target is found
            if(target>nums[mid] && target<= nums[h]) {
                return binarySearch(nums, mid+1, h, target);
            } else {
                // else make a binary search in left half
                return binarySearch(nums, l, mid-1, target);
            }
        }
    }
        
}