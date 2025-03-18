// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*
We can implement a modified version of binary search. Key is to find the pivot from which the array is rotated
We start with left=0 and right = n -1


Then calculate mid
We then determine if our target is at mid Location
if this is not our target, we determine which part is sorted, which helps us know which half the target might be
if element at left <= mid that means left is sorted
if element at right > mid that means right is sorted
both cannot be true as array is rotated.
Once it is known which part is sorted, we compare the start and end with the target to see if it contains the target
based on above steps, we modify left and right and repeat the process.

* */

class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n - 1;
        while(left<=right)
        {
            int mid=left + (right - left)/2;
            if(nums[mid]==target)
                return mid;

            if(nums[mid]>=nums[left]) // left sorted
            {
                if(target >= nums[left] && target< nums[mid])
                {
                    right=mid - 1;
                }
                else
                {
                    left=mid + 1;
                }
            }
            else // right sorted
            {
                if(target <= nums[right] && target > nums[mid])
                {
                    left=mid + 1;
                }
                else
                {
                    right=mid - 1;
                }
            }
        }
        return -1;
    }
}