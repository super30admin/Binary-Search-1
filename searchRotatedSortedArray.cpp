// Time Complexity : O(log n)
// Space Complexity : O(log n) due to recursion stack (can be O(1) with iterative version)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// This took some time to come up with the solution trying to get binary search to work with it.
// for example , Initially had issues with edge cases when left and mid values were equal
// Since that is the only one that we can search with log(n) time.
// It took some time to debug the cases one by one where the cases are failing.

// Your code here along with comments explaining your approach in three sentences only:
// This solution uses modified binary search to handle rotated sorted arrays without duplicates. 
// It identifies which half of the current range is sorted and narrows the search accordingly based on the target's position.
// Recursive calls are made only on the half that could possibly contain the target, ensuring logarithmic time complexity.

class Solution {
public:

    int binarySearch(vector<int>& nums, int l, int r, int target){
        int mid = l + (r - l) / 2;
        if (l > r)
            return -1;

        if (nums[mid] == target)
            return mid;

        // If left half is sorted
        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid])
                return binarySearch(nums, l, mid - 1, target);
            else
                return binarySearch(nums, mid + 1, r, target);
        } 
        // Otherwise, right half is sorted
        else {
            if (nums[mid] < target && target <= nums[r])
                return binarySearch(nums, mid + 1, r, target);
            else
                return binarySearch(nums, l, mid - 1, target);
        }
        return -1;
    }

    int search(vector<int>& nums, int target) {
        if (nums.size() == 1) {
            return nums[0] == target ? 0 : -1;
        }
        return binarySearch(nums, 0, nums.size() - 1, target);
    }
};
