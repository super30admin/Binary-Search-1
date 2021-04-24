/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

// Time Complexity :O(log n) where n in the number elements in the array reader
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) != INT_MAX && target > reader.get(high)){  // while target is greater than high, keep doubling high and set prev high to low
            low = high;
            high = 2*high;
        }
        cout<<high<<endl;
        while(low<=high){    // binary search
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
};