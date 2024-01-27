// Time Complexity : O(log n), since we are discarding half array everytime
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced issues with left and right sorted array conditions.


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left - ((left-right)/2); // to avoid integer overflow in case left and right are big values
            if(nums[mid] == target){
                return mid;
            }
            System.out.println(nums[mid]);
            //left array is sorted
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){ // element is in the left range
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{ //rigth array is sorted
                if(target > nums[mid] && target <= nums[right]){ // element is in the right range
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }   
        }

        return -1;
    }
}