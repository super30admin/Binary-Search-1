class SearchRotatedSortedArray {
    /**
     * Method searches for the target and returns its index. -1 if target not found
     * @param nums input array
     * @param target element to be searched
     * @return index of target or -1
     *
     * Time complexity: O(log(n)) // Sine we reduce problem space by half in each iteration
     * Space: O(1) No extra space is used
     */
    public int search(int[] nums, int target) {
        // Validate the array
        if (nums == null || nums.length == 0) {
            return -1; // Invalid input array
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // Set low, mid, high
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // This is for correctness and avoiding integer overflow
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left sorted
            if (nums[low] <= nums[mid]) {
                // Check if element is in left sub array
                if (target >= nums[low] && target < nums[mid]) { // Not including mid in this comparison
                    high = mid - 1;                              // since it has been already checked above
                } else {
                    // Enter right unsorted subarray
                    low = mid + 1;
                }
            } else {
                // This is right sorted array
                if (target > nums[mid] && target <= nums[high]) {
                    // Target is also in right sorted subarray
                    low = mid + 1;
                } else {
                    // Enter left unsorted subarray
                    high = mid - 1;
                }
            }
        }
        return -1; // If while loop completes without a result, we return -1 since target not found
    }

}

