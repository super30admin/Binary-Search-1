// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {

        if(nums.length == 0 || nums == null){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[low] <= nums[mid]){ //Checking if left half is sorted

                if(nums[low] <= target && target < nums[mid]){ //Checking if target is in the left half of the sorted left part
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }

            }else{ //left part is not sorted right one is so checking right sorted part
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
