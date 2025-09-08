// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach: one pass binary search, we check if the middle is the target, return
//           look on the left side of the array from low to mid, if element is >= low && < mid, find here else on the right
//           else find on the right, if element is < mid && >= high, find here else on the left
public class SearchRotatedSortedArray {

    /**
     * Searches for an element in a rotated sorted array
     *
     * @param nums   rotated sorted array
     * @param target the target to find
     * @return       the index of the target in nums, else -1
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] > target) high = mid - 1;
                else low  = mid + 1;
            } else {
                if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        System.out.println(searchRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 0)); //returns 4
        System.out.println(searchRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 3)); //returns -1
        System.out.println(searchRotatedSortedArray.search(new int[] {1}, 0)); //returns -1
    }
}
