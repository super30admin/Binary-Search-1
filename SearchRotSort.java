// Time Complexity : All the operations are done in O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Following the approach that always one side of binary search would be sorted.
1. if mid value is less than low value, then right is sorted search in it.
2. if mid value is greater low value, then search right.
*/
public class SearchRotSort {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if(nums == null || nums.length == 0) return -1;

        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println("nums1: " + search(nums, target));

        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;

        System.out.println("nums1: " + search(nums2, target2));
    }


}
