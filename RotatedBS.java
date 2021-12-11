// Time Complexity : O(logn)
// Space Complexity : O(logn) for recursive calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class RotatedBS {
    public int search(int[] nums, int target) {

        if(nums.length ==0) {
            return -1;
        }
        return  helper(nums, target, 0, nums.length-1);
    }

    private int helper(int [] nums, int target, int start, int end) {
        if(start>end) {
            return -1;
        }

        int mid = start +(end-start)/2;

        // If element is found, return the index.
        if(nums[mid] == target) {
            return mid;
        }
        // else check if the array is sorted in the first half
        else if(nums[mid] >= nums[start]) {
            // we see if the target is in first half range, then search in it
            // else search in second half
            if(target <= nums[mid]  &&  nums[start] <= target) {
                return helper(nums, target, start, mid-1);
            } else {
                return helper(nums, target, mid+1, end);
            }
        }
        // If array is not sorted in first half, its worth searching in both the halves
        // for the test case like this, [5 1 3] target = 5
        else {
            int ans = helper(nums, target, start, mid-1);
            return ans ==-1 ? helper(nums, target, mid+1, end) : ans;
        }
    }
}