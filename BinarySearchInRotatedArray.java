/**

nums = [4,5,6,7,0,1,2], target = 2

- Are there any duplicates?

0 1 2 
4 5 6 7

0< n < 4  

- check if first > last then it's rotated array.

target < 7 && < 4
 - in the right half
target < 7 && > 2
 - in the left half

target < mid
    target < end
        right half
    else
        left half
target > mid
    target > end
        left half
    else
        right half
        
// Time Complexity : O(logn) dividing the search space in half.
// Space Complexity : O(n) input array size + O(1) constant since no additional space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
        
**/
class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null ||nums.length == 0)
        {
            return -1;
        }
        
      
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (target == nums[mid])
            {
                return mid;
            }
            else if (nums[mid] >= nums[start])
            {
                if (target < nums[mid] && target >= nums[start])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else
            {
                if (target <= nums[end] && target > nums[mid])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
}