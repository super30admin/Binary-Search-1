// TC: O(logn)
// SC: O(1)
// Approach: In rotated sorted array one half of array will always be sorted
// Check for which side is sorted in the array and reject the other side by comparing low <= mid 
// Apply binary search and Check if the target exists in the range 
// Move low and high pointer accordingly until you find the target 
// Return target index if found else return -1

public class Search_In_Rotated_Sorted_Array {

  public int search(int[] nums, int target) {

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[low] <= nums[mid]) {
        if (nums[low] <= target && nums[mid] > target) { // left sorted
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (nums[mid] < target && nums[high] >= target) { // right sorted
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Search_In_Rotated_Sorted_Array obj = new Search_In_Rotated_Sorted_Array();

    int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;

    System.out.println("Target is at index " + obj.search(nums, target));
  }
}