// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
/** 
 * 1. Struggled with the logic to understand how to identify which side of the array is sorted
*/

// Your code here along with comments explaining your approach
/* 1. One thing we know for sure, one of the 2 sides from mid index of the array, will be sorted at all times.
      The sorted side can be identifies with the logic that if the middle element is greater than the element pointed by the 
      low, then left side is sorted. Otherwise, right side is sorted.
   2. After that, we can check if the target element falls in the sorted range, if it does, we search the sorted range. 
        Otherwise we search the non-sorted range.
*/
class SearchInRotated {
    public int search(int[] nums, int target) {
        int max = nums.length-1;
        int min = 0; int mid;
        if(nums==null || nums.length==0) return -1;

        while(min<=max)
        {
            mid=(min+(max-min)/2);
            if(nums[mid]==target)
                return mid;
            else if(nums[min] <= nums[mid]) //left is sorted
            {
                if(target<nums[mid] && target>=nums[min]) // target is in the left side
                    max=mid-1;
                else
                    min=mid+1;
            }
            else //right is sorted
            {
                if(target>nums[mid] && target<=nums[max]) // target is in the left side
                    min=mid+1;
                else
                    max=mid-1;
            }
        }
        return -1;
    }
}
