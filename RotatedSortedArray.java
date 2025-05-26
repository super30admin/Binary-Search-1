// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Find mid of the rotated sorted array , if mid value is equal to target return target else if start <= mid and target is greater than start
// and less than mid then search in left array else do same process in right array.
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while(start <= end){
            int mid = start + ( end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
