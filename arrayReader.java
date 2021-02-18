/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 1;
        while(reader.get(r) != Integer.MAX_VALUE && reader.get(r)<target)
        {
            l = r;
            r = r*2;
        }
        int mid = l+(r-l)/2;
        while(l<=r)
        {
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)<target)
            {
                l = mid+1;
            }
            else 
            {
                r = mid-1;
            }
            
            mid = l+(r-l)/2;
        }
        
        return -1;
    }
}