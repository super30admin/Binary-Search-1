/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInSortedArrOfUnknownSize {
    // public int search(ArrayReader reader, int target) {
    //     int lo = 0;
    //     int hi = 1;
    //     while(reader.get(hi) != Integer.MAX_VALUE && target > reader.get(hi)){
    //         lo = hi;
    //         hi = hi*2;
    //     }
    //     while(lo <= hi){
    //         int mid = lo + (hi-lo)/2;
    //         if(reader.get(mid) != Integer.MAX_VALUE)
    //         {
    //             if(target == reader.get(mid))
    //                 return mid;
    //             else if(target < reader.get(mid)){
    //                 hi = mid - 1;
    //             }
    //             else{
    //                 lo = mid + 1;
    //             }
    //         }
    //         else{
    //             hi = mid - 1;
    //         }
    //     }
    //     return -1;
    // }
    public int search(ArrayReader reader, int target) {
        int lo = 0;
        int hi = 1;
        while(target > reader.get(hi)){
            lo = hi;
            hi = hi*2;
        }
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(target == reader.get(mid))
                return mid;
            else if(target < reader.get(mid)){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return -1;
    }
}