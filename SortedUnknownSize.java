/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
  interface ArrayReader {
      public int get(int index) {}
  }
 */

class SortedUnknownSize {
    public int search(ArrayReader reader, int target) {
        int l = 0, h = 1;
        while(reader.get(h)<target){
            l = h;
            h = h*2;
        }
        while(l<=h){
        int mid = l+(h-l)/2;
        if(reader.get(mid) == target) return mid;
        else if(reader.get(mid) > target) h = mid-1;
        else l = mid+1;
        }
        return -1;
    }
}


// Time complexity - O(log(n)+log(m)) - 
// n: Number of elements on which the binary search is being performed
// m: Number of times high is being doubled

// Space Complexity - O(1) - No extra space used