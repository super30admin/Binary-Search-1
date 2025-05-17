// TC: O(logn)
// SC: O(1)
// Approach: Here we do not have the high value so we consider 1 as high
// and keep increasing high * 2 in every iteration
// We will then apply binary saerch and move low and high pointers until we find the target index

public class Search_In_Sorted_Array_Of_Unknown_Size {

  public int search(ArrayReader reader, int target) {

    int low = 0;
    int high = 1;

    while (reader.get(high) < target) {
      low = high;
      high = high * 2;
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (reader.get(mid) == target) {
        return mid;
      } else if (reader.get(mid) < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
