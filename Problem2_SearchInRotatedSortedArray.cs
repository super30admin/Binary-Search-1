// Approach: We could search linearly with O(n) time. But we know parts of the array is sorted. If we take mid and divide array, atleast one side of the array is sorted. We have to apply case analysis in combination with binary search and eliminate search space in each iteration.

// Time Complexity: O(log n) where n is the length os nums array
// Space Complexity: O(1)
public class Solution {
    public int Search(int[] nums, int target) {
        int lo = 0, hi=nums.Length-1;
        while(lo<=hi)
        {
            int mid = lo+ (hi-lo)/2;
            
            if(nums[mid] == target) return mid;
            
            // if left side of array is sorted
            if(nums[lo] <= nums[mid])
            {
                // if target is in sorted part
                if(nums[lo]<= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }else{ // if right side of array is sorted
                // if target is in sorted part
                if(nums[hi] >= target && target > nums[mid])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        
        return -1;
        
    }
}