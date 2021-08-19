// Time Complexity: Basic binary Search: O(log(n))
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : didn't get the gist of what we are achieving here

// Your code here along with comments explaining your approach
class Solution {
    // specified the range given
    public int search(ArrayReader reader, int target) {
        return binarySearch(target, 0, 10000, reader);
    }
    
    // performed basic binary search
    public int binarySearch(int target, int l, int h, ArrayReader reader) {
        if(h>=l) {
            int mid = (l + h)  /2;
            if(target==reader.get(mid)) {
                return mid;
            } else if(target< reader.get(mid)) {
                return binarySearch(target, l, mid-1, reader);
            } else {
                return binarySearch(target, mid+1, h, reader);
            }
        }
        return -1;
    }
}