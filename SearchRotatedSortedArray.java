// Time Complexity : O(log(n)) Binary search applied for searching the element in array
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
        SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        int indexResult = searchRotatedSortedArray.search(array, target);
        System.out.println(indexResult);
    }

}
