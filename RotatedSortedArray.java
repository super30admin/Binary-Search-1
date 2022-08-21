// Time Complexity : O(log n) where n is the number of elements in input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class RotatedSortedArray {
    public int search(int[] nums, int target) {

        //null check
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length -1;

        while (low <= high){

            int mid = low + (high-low) /2;

            //if target is the mid element
            if (nums[mid] == target)
                return mid;

                //Left sorted
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }
            }
            else{

                if(nums[high] >= target && nums[mid] < target) {
                    low = mid +1;
                }
                else high = mid - 1;
            }
        }return -1;
    }
}