/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Implemented brute force
// TimeComplexity : O(n)
// SpaceComplexity : O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        int i = 0;
        while(reader.get(i)!=target && reader.get(i)!=Integer.MAX_VALUE-1) i++;
        if(reader.get(i)==target) return i;
        return -1;
    }
}