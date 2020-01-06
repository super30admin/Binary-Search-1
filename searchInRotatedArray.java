class searchInSortedRotatedArray {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[low]) { // left half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else { // right half is sorted
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,19,1,2,4,5,6};
        System.out.println(search(nums, 11));
    }
}