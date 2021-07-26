using System;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

//Time Complexity : O(log(n))
// Space Complexity : O(1)
public class InfinteSortedArray{
    int low = 0; int high = 1;
    public int Search(ArrayReader reader, int target) {
      while(reader.get(high) < target){
         low = high;
         high = 2*high;
      }
     return binarySearch(reader, target,low,high);
  }
  private int binarySearch(ArrayReader reader, int target, int low, int high){
     while (low <= high){
      int mid = low + (high - low)/2;
         if(reader.get(mid) == target){
          return mid;
           }
          else if(reader.get(mid) > target){
           high  =mid -1;
           }
           else {
            low = mid + 1;
         }
       }
       return -1;
     }
}