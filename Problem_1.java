//LeetCode problem - 33
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/** Implementation is based on the idea that one half of the array would always be sorted. After retreiving the middle value, if the middle value is less than the value at last index, that means the right half is sorted. In such case if target is higher than the middle value but lower than the value at last index, then we can further check for the target in the right half. if the target is lower than the middle value then it should exist in the left subarray. if in case the right subarray doesnot fullfill the the sorting check, this means that the pivot element is anywhere in the right subarray. Thus, we know that in this cass that left sub array is sorted. We can again again compare the target with middle value and move our low and high pointer accordingly unless the target index is found.
*/
class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        

        while(low <= high){
            int mid = ((high - low)/2) + low; //calculate middle index of the array
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[high]){ //if right array is sorted,left array is unsorted
                if(target > nums[mid] && target <= nums[high])
                    low = mid +1 ;
                else
                    high = mid - 1;
            }else{ //if right array is unsorted
                if(target<nums[mid] && target >= nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } 
             
        }
        
        return -1;
    }
}
