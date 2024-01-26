// https://leetcode.com/problems/search-in-rotated-sorted-array/

// Time Complexity : O(log(n)), as we are reducing the search space by half(discard either left or right)
// Space Complexity : Constant space is utilised
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Find explanation in comments

class Problem2 {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        // Fact: Atleast one portion, left or right will be sorted
        // We will use this to build up our solution
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target)   return mid;

            // Check if left sorted array: arr[l]<=arr[mid]
            if(nums[l]<=nums[mid]){
                // Check if target lies in this sorted range: arr[l]<=target<arr[mid]
                // If yes, search in this half, or left portion
                if(nums[l]<=target && target<nums[mid])   r=mid-1;
                // if not then search in other half, or right portion
                else    l=mid+1;
            }
            // If left is not sorted, right must be sorted
            else{
                // Check if target lies in this sorted range: arr[mid]<target<=arr[r]
                // If yes, search in this half, or right portion
                if(nums[mid]<target && target<=nums[r])   l=mid+1;
                // if not then search in other half, or left portion
                else    r=mid-1;
            }
        }

        // If not found
        return -1;
    }
}
