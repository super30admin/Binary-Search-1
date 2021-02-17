// Thought 1 : Linear Search, O(n) time. 

// Thought 2 : Sort the array and then do a binary search, O(nlogn) + O(logn)

// Thought 3 : Do a binary search on the rotated array itself, but to reduce the search space take the left element, mid element
// and right element into consideration. 
// If left element is less than or equal to the mid element, and if the given target is greater than or equal to the first element
// and less than mid element, then reduce the search space between [left...mid-1] if not reduce it to [mid+1...right]
// Else if left element is greater than mid element, we have the right part [mid+1...right] in sorted order. So check whether target is greater than mid element and 
// less than or equal to the right element, then reduce the search space to [mid+1...right] else reduce it to [left...mid-1]

// Time Complexity : O(logn)
// Space Complexity : O(1)

public class SearchInRotSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;

        System.out.println(target1 + " found at index : " + search(nums1, target1));

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = 3;

        System.out.println(target2 + " found at index : " + search(nums2, target2));
    }
}