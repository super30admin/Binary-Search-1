/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     fun get(index: Int): Int {}
 * }
 */ 

 //Time Complexity O(logn)
 // Space Complexity O(1)

class Solution {
    fun search(reader: ArrayReader, target: Int): Int {
        var l = 0
        var r = 1

        while(reader.get(r) < target) {
            l = r
            r = r * 2
        }
        
        while(l <= r) {
            val mid = l + (r -l)/2
            if (reader.get(mid) == target) return mid
            else if( reader.get(mid) < target) l = mid + 1
            else r = mid - 1
        }
        return - 1
    }
}