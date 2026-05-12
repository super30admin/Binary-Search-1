// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We are using binary search to find the target in the rotated sorted array. 
// We calculate the mid index and then determine which side of the array is sorted.
// Based on the sorted side, we adjust our search range accordingly.
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
             int mid = low + (high - low)/2;
             if(nums[mid]==target){
                return mid;

             }if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid -1;
                }else{
                    low = mid +1;
                }
             }else{
                if(target <= nums[high] && target >= nums[mid]){
                    low = mid +1;
                }else{
                     high = mid -1;
                }
                
             }
             //5,6,7,0,1,2,3
           
        
           
            }
        
        return -1;

        
    }
}