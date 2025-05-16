/*
  Time complexity: O(log n)
  Space complexity: O(1)

  Code ran successfully on leetcode: Yes

  Approach: The fundamental logic when we reduce the search space by half in every iteration is that one half is always sorted.

*/

public class Solution {
    public int Search(int[] nums, int target) {
        int left = 0;
        int right = nums.Length-1;

        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[left]<=nums[mid])
            {
                if(nums[left]<=target && nums[mid]>target)
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
            else
            {
                 if(nums[right]>=target && nums[mid]<target)
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
