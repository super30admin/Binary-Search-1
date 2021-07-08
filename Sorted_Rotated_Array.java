// Time Complexity : O(log n) -> Binary Search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Partially (failed the base cases where array length was 0,1,2)
/* Any problem you faced while coding this : The point where we have to compare the mid element with the start element was the breaking point.
(wasnt able to come up with the breaking point) */
/* Your code here along with comments explaining your approach
Start with finding the mid element using start and end index, We are trying to find the Pivot element first. If the start element is
lesser than the mid element, it implies that the order of sequence has been maintained and pivot is on the right hand side (mid + 1 to end) else 
the pivot is on left side (start to mid - 1). Once the pivot is found, Check the target element comparison with nums[pivot] and nums[end]. If the 
element belongs there implies => do a binary search there else do a binary search from start to pivot -1.
*/
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        if(end < start){                        // handling the base cases
            return -1;
        } else if(end == start) {
            return ((nums[start]==target) ? start : -1);
        }
        int pivot = SearchPivot(start, end, nums);   // search for the pivot element 
        if (nums[pivot] <= target &&  target <= nums[end]){   // once you get the pivot check with the nums[pivot] and nums[end] range
        return BinarySearch(nums, pivot, nums.length-1, target);  // do the binary search accordingly.
        } else {
        return BinarySearch(nums, 0, pivot-1, target);
        }
    }
    public int SearchPivot(int start, int end, int[] nums){
         int mid = (start+end)/2;
         if(nums[mid] > nums[mid+1]) {
             start = mid+1;
         } else {
             if(nums[start]  <= nums[mid]){             // if the start element is smaller than the mid element, recursively call to find the pivot
                 SearchPivot(mid+1, end, nums);
                 } 
            else {
                 SearchPivot(start, mid-1,nums);
            }
         }
        return mid+1;
    }
    public int BinarySearch(int[] nums, int start, int end, int target){        // Once you decide the range of BS, do the BS with the fixed code.
        while(start <= end){
         int mid = ((start+end)/2);
         if(nums[mid] == target){
             return mid;
         } else if(nums[mid] > target) {
             end = mid-1;
         } else {
             start = mid + 1;
        }
    }
        return -1;      // element not found
    }
    }
