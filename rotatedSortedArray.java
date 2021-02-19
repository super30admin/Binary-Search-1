// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach , we check one part of the array from mid to see if the left of mid is sorted or right of mid is sorted
//if left of the mid is sorted which we check by comparing mid and the left value , we search for the element there
//when we dont find anything there , we move to the next half of the array to check if we can find the element there
class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length -1;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;
            //checking if left half is sorted
            else if(nums[l]<=nums[mid])
            {
                if(target >=nums[l] && target<nums[mid])
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            //moving to search in the right half of the array
            else
            {
                if(target <= nums[r] && target > nums[mid])
                {
                    l = mid + 1;
                }
                else
                
                    r = mid -1 ;
                
            }
            
        }
        return -1;
    }
}