// Search in a Sorted Array of Unknown Size

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes ; Approach 1(45/47), approach 2-all
// Any problem you faced while coding this : only 2 test cases are failing from approach 1 , should
// try and see about the issue

/**
 * // This is ArrayReader's API interface. // You should not implement it, or speculate about its
 * implementation interface ArrayReader { public int get(int index) {} }
 */

class BinarySearch3 {
  public int search(ArrayReader reader, int target) {

    // Approach 1: 45/47 cases passed
    //         return binarySearch(reader,0,1,target);
    //     }
    //     int binarySearch(ArrayReader reader,int low,int high, int target){
    //         int mid=low+(high-low)/2;
    //         if(reader.get(high*2)==Math.pow(2,31)-1){
    //             return bS(reader,low,high*2,target);
    //         }
    //         if(reader.get(mid)==target) return mid;
    //         else if(reader.get(mid)<=target) return binarySearch(reader,low,high*2,target);
    //         // else if(reader.get(mid)>target) return binarySearch(reader,mid+1,high*2,target);
    //         else return -1;
    //     }
    //     int bS(ArrayReader reader,int low,int high,int element){
    //         if (high >= low) {
    //       int mid = ((low + high) / 2);
    //       if (reader.get(mid) == element) return mid;
    //       if (reader.get(mid) > element) return bS(reader, low, mid - 1, element);
    //       else if (reader.get(mid) < element) return bS(reader, mid + 1, high, element);
    //     }

    //     return -1;

    // Approach 2:

    int high = 1;
    // getting the high value with looping
    while (reader.get(high) != Math.pow(2, 31) - 1) {
      high *= 2;
    }
    return bSearch(reader, 0, high, target);
  }

  int bSearch(ArrayReader reader, int low, int high, int element) {
    if (high >= low) {
      int mid = low + (high - low) / 2;
      if (reader.get(mid) == element) return mid;
      if (reader.get(mid) > element) return bSearch(reader, low, mid - 1, element);
      else if (reader.get(mid) < element) return bSearch(reader, mid + 1, high, element);
    }

    return -1;
  }
}