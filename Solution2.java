// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(logn), where n is the number of elements in nums. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It took a lot of time to think about the solution. 


// Your code here along with comments explaining your approach
class Solution2 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return mid;
            //if low to mid is sorted. 
            if (nums[low] <= nums[mid]) {
                //and if target lies between low to mid, searched on left side of the array. 
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                //else searched on the right side of the array. 
                else {
                    low = mid + 1;
                }
            }
            //else if mid to high is sorted
            else {
                //and if target lies between mid to right, searched on right side of the array. 
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                //else searched on the left side of the array
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}