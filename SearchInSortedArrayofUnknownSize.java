/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 // Time Complexity: 2log(n)
 // Space Complexity: O(1)

class Solution {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        // Find the search space - log(n)
        while(target > reader.get(high)){
            low = high;
            high = high *2;
        }

        // Find element in search space - log(n)
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}