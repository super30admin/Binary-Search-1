/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity:  O(log n), where n is an index of target value. 
// two operations mainly: to define search boundaries and to perform binary search.
// Space Complexity: O(1) since it's a constant space solution.
// Did this code run successfully on leetcode: Yes
// Did u face any difficulty while solvign this problem: No

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; 
        int high = 1;
        while(reader.get(high) < target) {
            low = high; // setting the current high as low
            high = high * 2; // to maintain constant space
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) // if middle is our target then return the mid value
                return mid;
            else if(reader.get(mid) >  target) { // if mid is > target then we perform modified binary                                                    // search on left side of the array 
                high = mid -1;
            }
            else {   // if mid is < target then we perform modified binary                                                         //search on right side of the array 
                low = mid+1;
            }
        }
        return -1; 
    }
}