// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


/* Aproach
1. Applying Binary Search... 
2. checking the target is equal to mid if yes return else  check the which side is sorted
3. then check target is lies on that side side or not.
*/
class Solution {
    public int search(int[] nums, int target) {

        //check for null
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length -1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid])
            {  //left sorted or not
                if(nums[mid] > target && nums[low] <= target)  //checking target lies in left half or not
                {
                      high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && nums[high] >= target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}