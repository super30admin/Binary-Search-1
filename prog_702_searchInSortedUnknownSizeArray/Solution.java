package prog_702_searchInSortedUnknownSizeArray;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }

public class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0 ;
        int high= 1 ;
        while(reader.get(high)<target){
            low = high ;
            high = high * 2 ;
        }
        return binary(low, high, reader, target);
    }
    public int binary(int low, int high, ArrayReader reader, int target){
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(reader.get(mid) == target){
                return mid ;
            }
            if(reader.get(mid)>target){
                high = mid -1 ;
            }
            if(reader.get(mid)< target){
                low = mid +1 ;
            }
        }
        return -1 ;
    }
}
*/