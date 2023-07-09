/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low=0;

        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) <= target){
            high = high*2;

        }
        return binarysearch(reader, target, low, high);
    }

    private int binarysearch(ArrayReader reader, int target, int low, int high){
        low =0;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)== target)return mid;
            else if(reader.get(mid)> target) high = mid-1;
            else low = mid +1;
        }
        return -1;
    }
}