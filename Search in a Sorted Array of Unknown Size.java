// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0;
        int h=1;
        while(reader.get(h)<target)
        {
            l=h;
            h=h*2;
        }

        while(l<=h)
        {
            int mid= l+(h-l)/2;

            if(reader.get(mid)==target)
            return mid;

            else if(target<reader.get(mid))
            h=mid-1;

            else
            l=mid+1;

        }
        return -1;


    }
}