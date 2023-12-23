// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return -1;
        int low =0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high)
        {
            mid = low + (high - low)/2;
            if(target == nums[mid])
                return mid;
            else if (nums[low] <= nums[mid])
            {
                //left side is sorted or not
                // if element lies in left side
                if(nums[low] <= target && nums[mid] >= target)
               {
                   high = mid-1;
               }
               else
                    low = mid+1;
            }
            else
            {
                // if element lies on right side
                if(nums[mid] < target && nums[high] >= target)
               {
                   low = mid+1;
               }
               else
                    high = mid-1;
                
            }
            
        }
        return -1;

    }
    public static void main(String[] args)
    {
        int [] num = {4,5,6,7,0,1,2};
        Solution s = new Solution();
        System.out.println(s.search(num,0));
     }
}