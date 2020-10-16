//LeetCode #. Search in a Sorted Array of Unknown Size
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I don't have the Leetcode premium
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/*
    First, we need to find a range of elements in which the target
    is present. Then we can use the normal binarySearch to find the target.
*/

class Solution {
public:
    int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        // if the target is after the 'high' index, we update the low pointer
        // with high and double the high pointer.
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        return binarySearch(reader, target, low, high);
    }
private:
    int binarySearch(Arrayreader reader, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reade.get(mid) > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}
