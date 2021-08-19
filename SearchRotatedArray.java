// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

class SearchRotatedArray {
    // Searched using binary search but checking all the edge cases
    // if the start is less than the mid then the rotation index is not the mid and it is to the right of the mid.
    // if the start is greater than the mid, then the rotation happens to the left of the mid.
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1 ;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        searchRotatedArray.search(new int[]{6, 7, 8, 9, 1, 2, 3, 4}, 2);
    }
}