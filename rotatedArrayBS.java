// Time Complexity :log(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :I was not checking if target lies between sorted part fixed this issue now

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;// calculate mid
            if (target == nums[mid]) {
                return mid;// if target is found return mid
            }
            if (nums[start] <= nums[mid]) {// if left part is sorted
                if (nums[mid] > target && nums[start] <= target) {// check if target lies between start and mid
                    end = mid - 1;// if yesshrink the boundaries
                } else {
                    start = mid + 1;// else move to right part
                }
            } else if (nums[mid] <= nums[end]) {// if right part is sorted
                if (nums[mid] < target && nums[end] >= target) {// check if target lies here if yes move start to mid+1
                    start = mid + 1;
                } else {
                    end = mid - 1;// else move to left side
                }
            }
        }
        return -1;
    }
}