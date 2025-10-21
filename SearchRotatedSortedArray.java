/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Time Complexity: O(log(n)) where n is number of elements in the array
 * Space Complexity: O(1)
 * 
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) { // left to mid is sorted e.g. 4,5,6,0,1,2,3
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // mid to right is sorted e.g. 6,0,1,2,3,4,5
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new SearchRotatedSortedArray().search(new int[] { 3, 4, 5, 6, 0, 1, 2 }, 1);
        System.out.println(search);

        search = new SearchRotatedSortedArray().search(new int[] { 6, 0, 1, 2, 3, 4, 5 }, 1);
        System.out.println(search);

        search = new SearchRotatedSortedArray().search(new int[] { 4, 5, 6, 0, 1, 2, 3 }, 4);
        System.out.println(search);

        search = new SearchRotatedSortedArray().search(new int[] { 4, 5, 6, 0, 1, 2, 3 }, 3);
        System.out.println(search);

        search = new SearchRotatedSortedArray().search(new int[] { 1, 2, 3, 4, 5, 6, 0 }, 3);
        System.out.println(search);
    }
}
