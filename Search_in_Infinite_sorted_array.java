/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Not submitted on LeetCode, don't have leetcode premium

// Take a loop and traverse all the elements in the array,and return true if it is found else false.

/**** Method 2 ****/
//Time Complexity: O(logn)
//Space Complexity: O(1)

//Not submitted on LeetCode, don't have leetcode premium

// So, as the length is unknown we try to find the section of array in which target is present by taking two variable lo and hi starting with 0 and 1, if and keep them updating to lo = hi and hi *=2 until we get a high which is greater than target. Now we do a binary search on the section we found.

/**** Method 1 ****/
// public class Search_in_Infinite_sorted_array {

//      public int search(ArrayReader reader, int target) {

//         for(int i =0;i<reader.length;i++){
//             if(reader.get(i) == target){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

/**** Method 2 ****/
public class Search_in_Infinite_sorted_array {

  public int search(ArrayReader reader, int target) {
    int lo = 0;
    int hi = 1;

    while (reader.get(hi) < target) {
      lo = hi;

      hi *= 2;
    }

    return binarySearch(reader, target, lo, hi);
  }

  private int binarySearch(ArrayReader reader, int target, int lo, int hi) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (reader.get(mid) == target) {
        return mid;
      } else if (reader.get(mid) > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return -1;
  }
}
