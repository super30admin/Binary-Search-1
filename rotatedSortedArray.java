// Time Complexity : O(logN)
// Space Complexity : O(1) constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding logic inside first else condition. It could have been
//   if(target > nums[low] && target <= nums[mid]){
//                    high = mid-1;
//                }else{
//                    low=mid+1;
//                }
// But it is not working properly

// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[low] <= nums[mid]){ // going in sorted array
                if(target >= nums[low] && target < nums[mid]){ // if true then it means target lies in left side
                    high = mid-1;
                }else{
                    low = mid +1; // If not, then in right side
                }
            }else{
                if(target > nums[mid] && target <= nums[high]){ // searching here and also because at last now it is sorted part
                    low = mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}