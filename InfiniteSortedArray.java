
// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class InfiniteSortedArray {

  public int search(ArrayReader reader, int target) {
    int l = 0;
    int h = 1;

    // target outside the range
    while(target> reader.get(h)){
      l=h;
      h=h*2;
    }

    if(target== reader.get(l)) return l;

    //target within the range
    while(l <= h) {
      int m = l + (h - l) / 2;

      if (reader.get(m) == target) return m;

      // target in left side
      if (reader.get(m) > target && target >= reader.get(l)) {
        h = m - 1;
      }

      //target in right side
      else {
        l = m + 1;
      }
    }

    return -1;
  }
}
