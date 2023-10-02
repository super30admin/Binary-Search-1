//Time complexity O(log n)
//Space complexity 0(1)

// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : NO

// We can solve this problem by using Binary searach. When we apply  (low, mid, high) on  rotated sorted array
// at least one side from mid is sorted and other side is unsorted.
// If left side is sorted then check if the target is in that range otherwise search the right side and return the positon
// else return -1
// If the right side is sorted then check if the target is in that range first otherwise search the other side return index
// else return -1


public class SearchInRotatedSortedArray {

    //At least one side is sorted.
    // [4,5,6,7,0,1,2,3] target 0 mid = 7
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Get the sorted Array Range
        while(low <= high) {

            int mid = low + (high - low) / 2;  //avoid integer overflow
            if(nums[mid] == target){
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                //left sorted
                // check if the target is in this left sorted array range.
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //right sorted
                //check if the target is in right sorted array
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        //target not found
        return -1;
  }
}
