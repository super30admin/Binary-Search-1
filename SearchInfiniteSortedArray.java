/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//ignore the interface
//tc = o(log n) //binary search
//sc = o(1) 
interface ArrayReader {
    public int get(int index);
}
 class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(target > reader.get(high)){
            low = high;
            high = 2 * high;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target > reader.get(mid)){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}
public class SearchInfiniteSortedArray {
    public static void main(String[] args) {
        
    }
}
