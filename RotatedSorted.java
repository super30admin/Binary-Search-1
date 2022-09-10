// Time Complexity : O(log (n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

class Solution {
    int nums[];
    int target;
    public int pivotIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }
    
    public int search(int left, int right) {
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            else {
                if (target < nums[pivot]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        
        if (n == 1) {
            return this.nums[0] == target ? 0 : -1;
        }
        
        int rindex = pivotIndex(0, n - 1);
        
        if (nums[rindex] == target) {
            return rindex;
        }
        
        if (rindex == 0) {
            return search(0, n - 1);
        }
        if (target < nums[0]) {
            return search(rindex, n - 1);
        }
        return search(0, rindex);
    }
}