/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int low = 0; 
        int high = 1;
        //Step1 -find the range by expanding twice
		// condition 1 high be less or equal to target then expand range
		// condition 2 high greater than target dont expand do binary search  directly		
        while (reader.get(high  ) <= target){ 
            low = high;
            high = 2* high;
        }
        //Step2 -- perform regular binary search 
       return binarySearch(reader, target, low, high);
    }

    
    private int binarySearch(ArrayReader reader,int target,int low,int high){
          while(low <= high){
            int mid = low + (high -low )/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } 
        return -1;
   }
}