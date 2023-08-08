// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
* Array left or right to mid point will be left sorted or right sorted ,
* need to check whether target is present within left sorted or right sorted array , perform binary search on sorted array
*/
class Problem3 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low<=high){
             mid = low + (high - low) / 2;
             if(nums[mid]==target){
                 return mid;
             }else if(nums[low]<=nums[mid]){
                 // left sorted
                 // check if target present in left sorted arr
                 if(nums[low]<=target && target<nums[mid]){
                    high = mid - 1;
                 }else{
                    low = mid + 1;
                 }
             }else{
                 // right sorted
                 // check if target present in right sorted arr
                 if(target>nums[mid] && target<=nums[high]){
                     low = mid + 1;
                 }else{
                     high = mid - 1;
                 }
             }
        }
        return -1;
    }
}
