// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int searchUnknown(ArrayReader reader, int target) {
    int l=0;
        int h=2;
        int mid;
        while(reader.get(h)<target){
            l=h;
            h=2*h;
        }
        while(l<=h){
            mid=l+(h-l)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}