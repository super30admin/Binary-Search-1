// Time Complexity : Log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//  Take 2 pointers L and H - calculate Mid - check overflow condition
//  Check if it  is left sorted or right sorted.
// if the mid element matches the target return it.
class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums ==null || nums.length == 0) return -1;

        int low = 0;
        int high= nums.length -1;
        while(low <= high){
            int mid = low + (high-low) /2; //overflow condition - convert it to long value 2
            if(nums[mid] == target) {
                return mid;
            }else if(nums[low] <= nums[mid] ){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else  {
                //if it is right sorted
                if(nums[mid] <target && nums[high] >= target) {
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}