/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        int low=0, high=1;

        while(reader.get(high) < target){
            low = high;
            high *=2;
        }

        while(low <= high){
            int mid = (low+high)>>1;
            int element = reader.get(mid);
            if(element==target){
                return mid;
            }else if(element > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    /**
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
}