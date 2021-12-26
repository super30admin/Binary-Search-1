// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 2;
        int times=0;
        while(l<=h)
        {
            if(reader.get(h) == target)
            {
                return h;
            }
            else if(reader.get(h) < target)
            {
                l=h;
                h=2*h;
            }
            else if(reader.get(h) > target)
            {
                break;
            }
        }
        while(l<=h)
        {

            int mid= l+(h-l)/2;

            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) < target)
            {
                l=mid+1;
            }
            else
            {
                h = mid-1;
            }
        }
        return -1;
    }
}