/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 interface ArrayReader {
      public default int get(int index) {
          return index;
      }
  }
 /*
Time complexity - O(logn)
Space Complexity - O(1)
 */

class SearchInSortedArrayUnknownLC701 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        while(low <= high) {
            int mid = low + (high - low) /2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }

        }
        //if(reader.get(low) == target) return low; - I can add this line id I say in while loop (low < high)
        return -1;

    }
}

