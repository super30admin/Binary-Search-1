// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Understood it clearly in class

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0, h=1;
        while(reader.get(h)<=target)
        {
            l= h;
            h = h*2;
        }
        return bs(reader, target, l, h);
    }
    public int bs(ArrayReader reader, int target, int l, int h){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)>target) h = mid-1;
            else l = mid+1;
        }
        return -1;
    }
}