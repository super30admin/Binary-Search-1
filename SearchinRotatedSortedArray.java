
// Time Complexity :O(log n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
// I made use of the solution discussed in class.
//Linear Search is O(N)
//Atleast 1 half of the array is sorted,
//  so we can check if the target lies in the sorted half and discard the other half.
//  We repeat this process until we find the target or the search space is empty.
//We follow the binary search approach, but we need to determine which half of the array is sorted 
// and whether the target lies in that half before deciding which half to search next.

class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
       
        //left side is sorted
        while(low<=high)
        {
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
        {
            return mid;
        }
        if(nums[low]<=nums[mid])
        {
            if(nums[low]<=target && nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        //right side is sorted
        else
        {
             if(target > nums[mid] && nums[high]>=target)
             {
                low=mid+1;
             }
             else
             {
                high=mid-1;
             }
        }

        }
        return -1;
        
    }
}