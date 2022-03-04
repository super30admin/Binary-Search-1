public class RotatedSortedSearchSplitArray {
    public int search(int[] nums, int target) {
        int pivot = findMinIndex(nums);
        int leftSearchResult = bs(nums, target, 0, pivot-1);
        if(leftSearchResult != -1) {
            return leftSearchResult;
        } 
        return bs(nums, target, pivot, nums.length-1);
    }
    private int findMinIndex(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid-1]) {
                return mid;
            }
            if(nums[mid] < nums[0]) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return 0;
    }
    private int bs(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
