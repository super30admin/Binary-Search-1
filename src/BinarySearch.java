// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


/**
 * This is twisted Binary search problem. In this, after finding
 * the mid element and checking if it is the target, return the 
 * mid index if it matches with the target. Else there are two
 * cases in searching. 
 * First case: Check if the left element <= mid element. If so, then
 * we are in a sorted subarray. Then check if target <=
 * left element and target < mid element. If so, that means the target
 * is in this range. So, reduce right to mid - 1. If not in this range,
 * then it would be in the other half. So, update left = mid + 1.
 * Second case: If left element > mid element, that means the 2nd half of
 * the array is the sorted array with elements less than the left element.
 * So, check if the target > mid and target <= right element. If present, then
 * update left to mid + 1. If not present, then it could be in the 1st subarray.
 * So update right to mid - 1. If not present in the array, return -1.
 *
 */
public class BinarySearch {
	public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if(nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
