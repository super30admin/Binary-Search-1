public class SearchInARotatedSortedArray {

    // We can use modified binary search. As one of the half must be a sorted array.
    // Find the mid and check if the left elements are sorted then check if the
    // target is present in there or not. If it in range , move left, else move
    // right.
    // Else the remaining gonna be sorted, Again check if the element between the
    // range or not. If it range, move righ side. else move left side.

    // TC: O(logN) - Where N is number of elements in the given array.
    // SC: O(1) - Not using any extra space
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[low] <= nums[mid]) {
                    if (target >= nums[low] && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] <= nums[high]) {
                    if (target >= nums[mid] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInARotatedSortedArray searchInARotatedSortedArray = new SearchInARotatedSortedArray();
        int result = searchInARotatedSortedArray.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
        System.out.println("Ther result: " + result);
    }
}
