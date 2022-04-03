// Time Complexity : O(log(N))
// Space Complexity : O(1), No extra data structure used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
    /*
    1. Keep narrowing the search space, by deciding to check in left half or right half.
     */
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;

        int low=0, high=nums.length-1, mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}