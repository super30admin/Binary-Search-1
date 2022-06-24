/*
 Time Complexity - O(log n) as it uses binary search
 Space Complexity - O(1) no extra memory used
 Have all test cases passed on leetcode? Yes
 */

 /*
As the array is sorted in ascending error and then rotated, the midpoint of the array divides the array into
an unsorted array, sorted array either of which could be onto the left/right of midpoint.
Determine the sorted side and check if target is the range of sorted subarray. If yes apply binary search further on it to get
the index of element. If not, look for the target in the other unsorted subarray.Keep doing this until all the elements in the
array are exhasuted.
*/
public class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) 
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
