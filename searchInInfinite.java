// Time Complexity : O(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class searchInInfinite {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = 1;

        while (nums[high] < target) {
            low = high;
            high = high * 2;
        }
        return binarySearch(nums, low, high, target);
    }

    private int binarySearch(int nums[], int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        searchInInfinite obj = new searchInInfinite();
        int nums[] = { 1,2,3,4,5,6,7,8,9,10};
        int target = 2;

        int index = obj.search(nums, target);
        if (index != -1) System.out.println("Target at index:" + index);
        else System.out.println("Target not found");
    }
}