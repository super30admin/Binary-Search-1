// Time Complexity : O(log n) as we keep dividing the search space into two halves
// Space Complexity : O(1) as we do not use any auxiliary space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* 
 * Problem: Search In a Rotated Sorted Array
 * Approach: Binary Search
 * In this approach, we perform a binary search on nums array. Since, the array is rotated, we expect one of the halves
 * to be completely sorted. In order to find which side is sorted, we check the if the element at the left index is smaller than
 * or equal to the element at mid which means they are sorted. If not, it is safe to say that the right portion is sorted.
 * Within the sorted array, we check if the target is within the range. Depending upon target falls in the range or not, we 
 * move the left and right pointers to select the correct portion of array. We keep repeating the binary search until left and 
 * right pointers do not cross each other.
 * 
 */
public class SearchInARotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[left] <= nums[mid]) {
                    // left side is sorted
                    if (nums[left] <= target && nums[mid] >= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // right side is sorted
                    if (nums[mid] <= target && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;

        int[] nums2 = {1};
        int target2 = 0;

        SearchInARotatedSortedArray searchInARotatedSortedArray = new SearchInARotatedSortedArray();
        
        int result1 = searchInARotatedSortedArray.search(nums1, target1);
        System.out.println(result1);
    
        int result2 = searchInARotatedSortedArray.search(nums2, target2);
        System.out.println(result2);
    }
}