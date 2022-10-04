// TC = O(logM + logN)
// SC = O(1)

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
        
        //Now update both high & low        
        while (target > reader.get(high)){      // TC = O(logM)
            low = high +1;
            high = high * 2;    // high may out of bound but it will have value = Integer.MAX_VALUE
        }
        
        
        while (low <= high){        // BS => TC = O(logN)
            int mid = low + (high - low)/2;
            int midVal = reader.get(mid);
            if (midVal == target) return mid;
            else if (midVal < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
