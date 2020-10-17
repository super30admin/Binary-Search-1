// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using binary search to check which side of the array is sorted w.r.t mid of the array

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null && nums.length==0) return -1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){ //left side of mid is sorted
                if(nums[low]<=target && target<nums[mid]){ //check if target lies between the low(include) and mid
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            else { // right side of the mid is sorted
                if(nums[mid]<target && target<=nums[high]){// check if target lies between the mid and high(included)
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}