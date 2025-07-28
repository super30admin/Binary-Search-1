// Time Complexity :  O(log(p)) where p is index of target if present
// because we are expanding till that range logarithmically
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : line 19 and line 18 <= instead of <
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     fun get(index: Int): Int {}
 * }
 */

class Solution {
    fun search(reader: ArrayReader, target: Int): Int {
        var left = 0
        var right = 1
        //get range
        while(reader.get(right) < target){
            left = right // we are doing this because if the right is still less than target,
            //then everything before right (from 0 to right-1) including left is also less than target.
            right = right * 2
        }

        while(left <= right){
            val mid = left + (right - left)/2
            val midV = reader.get(mid)
            when{
                midV == target -> return mid
                midV > target -> right = mid - 1
                midV < target -> left = mid + 1
            }
        }

        return -1
    }
}