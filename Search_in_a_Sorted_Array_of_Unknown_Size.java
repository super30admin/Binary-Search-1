/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        int low = 0;
        int high = 1;

        while(target>reader.get(high)){
            low=high;
            high = high *2;
            if(reader.get(high) == target) return high;

        }


        // binary search
        while(low<=high){
            // to prevent integer overflow use this
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target<reader.get(mid)){
                high = mid -1;

            }
            else{
                low = mid+1;
            }
        }

        return -1;
    }
}