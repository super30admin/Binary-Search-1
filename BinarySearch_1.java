// Time Complexity : O(logN) - N is size of the array
// Space Complexity : O(1) - No extra data structure is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here to have a better time complexity used Binary Search by having two pointers and a mid value;
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == target) return 0;
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
             else if(nums[mid] >= nums[left]){
                if(nums[mid] > target && target >= nums[left]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] <= nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// Your code here along with comments explaining your approach
