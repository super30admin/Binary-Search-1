// Time Complexity :O(Log(N)).
// Space Complexity :O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){return mid;}
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target&& nums[mid] >= target){
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target&& nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}