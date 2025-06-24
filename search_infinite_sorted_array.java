// This solution finds given target in an infinte sorted array using regular BinarySearch but modified to find low and high values
// Time complexity: O(log n) <-- same as binary search + O(n) to iterate over the array to find the range where target might exist
// Space Complexity : O(1) <-- as we are not using any additional data structure for storage but only using variables.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
            // Check if we already found target at high index
            if(reader.get(high) == target){
                return high;
            }
        }
        
        return binarySearch(low, high, target, reader);
    }

    // Normal BinarySearch
    private int binarySearch(int low, int high, int target, ArrayReader reader){
        while(low <= high){
            // Prevent Integer overflow
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target){
                return mid;
            }

            else {
                if(target > reader.get(mid)){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
