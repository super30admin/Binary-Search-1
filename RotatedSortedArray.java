// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
/**
 * what i know ? O(log n) can be done by divide and conqure, use binary search, if split, one of them can be
 * sorted, and chan check if target can be 
 * 
 * solution to problem idea? not helpful
 * 
 * 
 * 
 * issues:
 * comparing target with first, last and middle but the exit logic as  if (first > last) caused issues
 * missed return statement again for recursive function
 * if (nums[first] <=nums[middle]), missed "=" caused index out of bound as it leads to search same set of list with decrement in index.  
 * logic that if one set of array is sorted, the other by default not sorted
 * middle = lenght/2 whill always be constant, because we are not changing the array
 */
// Your code here along with comments explaining your approach
class Solution {

    public int search(int[] nums, int first, int last, int target) {
        if (first > last)
            return -1;
        int middle = (first + last) / 2;
        if (nums[middle] == target)
            return middle;
        if (nums[first] <=nums[middle]) {
            if (nums[middle] >= target && target >= nums[first]) {
                return search(nums, first, middle - 1, target);
            }
            return search(nums, middle + 1, last, target);
        }
        if(nums[middle] >=nums[last]){
            if (nums[middle] <= target && nums[last] >= target) {
                return search(nums, middle + 1, last, target);
            }
            return search(nums, first, middle - 1, target);
        }
        return -1;
    }

    public static void main(String args[]) {
        Solution ob = new Solution();
        int arr[] = { 3,1 };
        int n = arr.length;
        int x = 1;
        int result = ob.search(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}