import java.util.*;

public class RotatedSortedArray {
  public int search(int[] nums, int target) {
    int leftIdx = 0, rightIdx = nums.length - 1;

    while (leftIdx <= rightIdx) {

      int midIdx = (leftIdx + rightIdx) / 2;

      if (nums[midIdx] == target) {

        return midIdx;
      }

      if (nums[midIdx] >= nums[leftIdx]) {

        if (target > nums[midIdx] || target < nums[leftIdx]) {
          leftIdx = midIdx + 1;
        } else
          rightIdx = midIdx - 1;
      } else {
        if (target < nums[midIdx] || target > nums[rightIdx]) {
          rightIdx = midIdx - 1;
        } else
          leftIdx = midIdx + 1;
      }
    }

    return -1;

  }
}

class Main {
  public static void main(String args[]) {
    RotatedSortedArray rsa = new RotatedSortedArray();
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    int result = rsa.search(nums, 0);
    System.out.println(result);
  }
}
