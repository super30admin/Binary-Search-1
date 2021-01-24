/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target){
          return 0;
        }
        if(reader.get(0) > target){
          return -1;
        }
      
        int left = 1;
       
      //first find the high pointer
          // Find the index point where the value goes from finite to infinite
      // and then perform binary search
      
      int high = getHighPointer(reader,target,left);
      
      return BinarySearch(left,high,reader, target);
      
     
    }
  
  
    public int getHighPointer(ArrayReader reader, int target, int left){
      int high = 10000;
      while(reader.get(left) <= target){
        if(reader.get(left) == target){
          return left;
        }
        if(reader.get(left) < target){
          left = left * 2;
        }
        if(reader.get(left) > target){
          high = left;
        }
      }
      return high;
    }
  
    public int BinarySearch(int left,int high,ArrayReader reader, int target){
      while(left <= high){
        int mid = left + (high - left)/2;
        if(reader.get(mid) == target){
          return mid;
        }else if(reader.get(mid) > target){
          high = mid - 1;
        }else{
          left = mid + 1;
        }
      }
      return -1;
    }
}
