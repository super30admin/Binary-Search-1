import java.util.*;
import java.lang.*;

public class SortedArrayUnknown {

  /**
   * Time complexity is O(logn)
   * Space complexity is O(1)
   * Used the mathetical deduction on factor of 2 either *2 or /2, for a given
   * space it is an O(logn) search space Time complexity.
   * Since we don't have access to size of provided secret array we start with
   * assumption of reading 0th index & 1st index and then check if 0 or 1 is
   * target if not we keep increasing search space by a factor of 2 on right side
   * of array space. Once the search space is identified we move to applying
   * binary traditional algo.
   * Here the integer overflow edge case is handled by adding right-left/2;
   *
   */

  /**
   * // This is ArrayReader's API interface.
   * // You should not implement it, or speculate about its implementation
   * interface ArrayReader {
   * public int get(int index) {}
   * }
   */

  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == target)
      return 0;
    if (reader.get(1) == target)
      return 1;

    int leftIdx = 0, rightIdx = 1, midIdx, getNum;

    while (target > reader.get(rightIdx)) {
      leftIdx = rightIdx;
      rightIdx *= 2;
    }

    while (leftIdx <= rightIdx) {
      midIdx = leftIdx + (rightIdx - leftIdx) / 2;
      getNum = reader.get(midIdx);

      if (getNum == target)
        return midIdx;
      if (getNum > target)
        rightIdx = midIdx - 1;
      else
        leftIdx = midIdx + 1;
    }

    return -1;
  }

}
