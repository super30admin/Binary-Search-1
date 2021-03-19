/** Leetcode Problem Number 702 - Search in a Sorted Array of Unknown Length */

public class SearchSortedArrayInfinite {
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
        while(reader.get(high)<target){
            low =high;
            high = 2* high;
        }
        return binarySearch(reader, low, high, target);
    }
    
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            int x = reader.get(mid);
            if(x == target){
                return mid;
            }
            else if(target > x){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
}
