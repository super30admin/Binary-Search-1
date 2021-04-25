// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Np
// Approach: Check edge cases for array, set low index at 0 and high index at the array end index
// Till low is less than or equal to high, calculate mid, if right half is sorted, check if target element is in left half if yes then change high and low index 
// and visa versa for the right half  

// Your code here along with comments explaining your approach
class RotatedSortedArray {
    public int search(int[] nums, int target) {
        // To check edege case if the array is empty
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low]<=nums[mid]) // To check if the left half is sorted
            {
                if(nums[low]<=target && nums[mid]>target) // To check if target is in left half
                {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else {
                 if(nums[mid]<target && nums[high]>=target) // To check if target is in right half
                 {
                     low = mid + 1;
                } else {
                     high = mid -1;
                }
            }
        }
        return -1;     
    }
}
