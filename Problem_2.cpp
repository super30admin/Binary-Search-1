/*
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
    I'm using a binary search to looik for where the target element
    might lie. There might be a case that the element is in the
    sorted part of the array or in the unsorted part of the array.
    I check if the mid is equal to the target element and if it is
    then return the mid. First I have an if condition to check which
    side of the array is sorted and then I check if the target is less
    than the nums[mid] && nums[l] is greater than the target that means
    that the target lies in the sorted part of the array so then I'll do
    a binary search on that part and vise-versa for the other case.
*/

#include <vector>

class Solution {
public:
    int search(std::vector<int>& nums, int target) {
        int l(0), r(nums.size() - 1);
        int mid;

        while(l <= r) {
            mid = l + (r - l)/2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[l] ) r = mid - 1;
                else l = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return -1;
    }
};