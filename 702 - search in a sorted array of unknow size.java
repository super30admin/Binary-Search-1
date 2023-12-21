/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution_1 {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 10000;
        int mid = 0;

        while(left < right){
            mid = left + (right - left) / 2;
            if(reader.get(mid) == target){
                return mid;
            }
            else{
                if(reader.get(mid) < target){
                    left = mid +1;
                }
                else{
                    right = mid;
                }
            }
        }
    return -1;
    }
}