// Approach: Define Search space/limits and then perform binary search. Since it is a strictly increasing sequence, we can conclude each element is unique in the array. So the search space would be from start index to target
// Time Complexity: O(log t)
// Space Complexity: O(1)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

class Solution {
    public int Search(ArrayReader reader, int target) {
        int start =0, end = target-reader.Get(start);
        
        while(start<=end){
            int mid = start + (end-start)/2;
            int midVal = reader.Get(mid);
            if(midVal == target)
                return mid;
            else if(target < midVal)
                end = mid-1;
            else
                start = mid+1;
        }
        
        return -1;
        
    }
}