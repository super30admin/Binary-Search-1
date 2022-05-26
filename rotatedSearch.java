// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I had a problem in finding pivot element as it gives error of out of index

class Main {

    // to get pivot element from array is rotated
    public static int getPivot(int[] nums) {
        // inlialze the value of l and r
        int l = 0;
        int r = nums.length - 1;

        // if left most element is less then rigth most element that means array is
        // alredy sorted so we return 0
        if (nums[l] < nums[r])
            return 0;

        // to get the index of the pivot element we are using binary search method but
        // little diffrently
        while (l <= r) {

            // find the mid element
            int mid = (l + r) / 2;

            // if mid element is greater then mid +1's element then we found our pivot
            // element
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[l]) {
                // else if mid element is less then that means our pivot element is in first
                // half so,
                r = mid - 1;
            } else {
                // else our pivot element in second half so,
                l = mid + 1;
            }

        }
        return 0;

    }

    public static int binarySearch(int[] nums, int l, int r, int target) {

        // traverse for finding the target element
        while (l <= r) {
            // find the mid element
            int mid = (l + r) / 2;
            // if mid elemen is equal to our target element then we return mid index;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // else if mid element is greater then target that means our target element may
                // be in first half of the array. So,
                r = mid - 1;
            } else {
                // else target element in second half of the array. So,
                l = mid + 1;
            }
        }
        // if array is not in our array we return -1
        return -1;
    }

    public static int search(int[] nums, int target) {
        // for the edge case if array size is 1 then our target element is equal to one
        // element that is available in the array return that element or return 0;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        // find the pivot element
        int pivot = getPivot(nums);

        // if pivot element is 0 that means our array is already sorted so, we do normal
        // binary search
        if (pivot == 0)
            return binarySearch(nums, 0, nums.length - 1, target);
        // if our target element is found on pivot index return that element
        if (nums[pivot] == target)
            return pivot;

        // if target element is greater than or equal to lowest element in first half
        // divided by pivot than we search on the first half else we search on the
        // second half
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(target + " is on index " + search(nums, target));
    }
}