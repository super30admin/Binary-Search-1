class SearchRotatedSortedArray {
    /*
        Time complexity - O(log n)
        Space complexity = O(1)
        to search in a rotated sorted array using binary search, we need to determine in which 
        part of the array the target lies in. If mid element >= low element, it means the array 
        is in sorted order. Check if mid element > target and low element <= target, if so we 
        search in the left side lese we search in the right side of the array. When searching in 
        right side if mid element < target and high ele is >= target then search in the right side of mid
        else search on the left side. If mid element equals target we return index. Else we return -1.
    */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}