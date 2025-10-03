/**
 * In Rotated sorted array, either left array or right array is always sorted.
 * Using the above logic, we check if the target is present array in the sorted array.
 *  a) If the target is persent in sorted array, we do binary search on it.
 *  b) If the target is not present in sorted array, we ignore this array and do binary search on other part of array
 */

class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        } else {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                //int mid = (start + end)/2 <-- this will cause int overflow
                int mid = start + (end - start) / 2;
                //If value at pivot/mid is the target, return mid index
                if (nums[mid] == target) return mid;

                //check if left array is sorted
                if (nums[start] <= nums[mid]) {
                    //check if the targe is in the left sorted array.
                    if (target >= nums[start] && target < nums[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
                //Right array is sorted
                else {
                    //check if the targe is in the right sorted array.
                    if (target > nums[mid] && target <= nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("" + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}