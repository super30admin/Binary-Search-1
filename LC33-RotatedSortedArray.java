// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, some logical error


// Your code here along with comments explaining your approach in three sentences only
/**
rotated sorted means last elem < first
and lets say pivot is k
if target<nums[0] target is right side of pivot 
else left side

case-1: target is right
if (mid > l and l>r) => r = mid-1
else { if mid>target r= mid-1 else l = mid+1}


case-1: target is left
if (mid > l  and l>r) => l = mid+1
else { if mid>target r= mid-1 else l = mid+1}

*/
class Solution {
    public int search(int[] nums, int target) {
        
        int l=0;
        int r=nums.length-1;

        if (target < nums[0]) {
            // case1: target is right side of pivot
            while (l<=r) {
                int mid = (l+r)/2;
                if (target == nums[mid]) return mid;

                if (nums[mid]>=nums[l] && nums[r]<nums[l]) l = mid+1;
                else {
                    if (nums[mid] > target) r = mid-1;
                    else l = mid+1;
                }

            }

        } else {
            // case2: target is left side of pivot
            while (l<=r) {
                int mid = (l+r)/2;
                if (target == nums[mid]) return mid;

                if (nums[mid]<=nums[r] && nums[r]<nums[l]) r = mid-1;
                else {
                    if (nums[mid] > target) r = mid-1;
                    else l = mid+1;
                }

            }

        }
        
        return -1;
    }
}
