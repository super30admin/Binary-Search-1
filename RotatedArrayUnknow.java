/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        // increase search space by checking starting from i = 0 , reader[i] == target
        // 2 * i , till reader[i] >= target
        // that will give us high point

        // then do binary search from 0 to that index

        int r = 0;
        while( reader.get(r) <= target ){
            if( reader.get(r) == target ){
                return r;
            }
            if( r == 0 ){
                r = r + 1;
            }
            else{
                r = r * 2;
            }

        }

        int l = 0;

        int mid = 0;

        while( l <= r ){

            mid = l + (r-l)/2;
            if( reader.get(mid) == target ){
                return mid;
            }
            else if( reader.get(mid) < target ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;

    }
}