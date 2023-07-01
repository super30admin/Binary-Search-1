// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach:
/* The array is rotated sorted, meaning at a given point in time one part of the array will be sorted if we calculate the mid.
   It can either be left sorted or right sorted
   as first step we decide which part to go for, by deciding if it is left sorted or not, if it is left sorted we check if the target lies on that side
  then we perfom binary search on the side which contains the target - ie we keep dividing in half unless either mid == target or else return -1
*/

class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        if(nums == null || nums.length == 0) return -1; //null
        while(low<=high){
            mid = low +  (high - low)/2;
            if (nums[mid] == target){
                return mid;
            }
            //left sorted
            else if (nums[low]<= nums[mid]){
                if (nums[low]<=target && nums[mid]>target){
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }
            }
            //right sorted
            else{
                if (nums[mid]< target && nums[high]>=target){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }        
        }
        return -1;
        
        }
    }