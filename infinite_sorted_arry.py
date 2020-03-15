"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
// Any problem you faced while coding this : Had some back and forth in trying to 
set the low and high

// Your code here along with comments explaining your approach
Algorithm Explanation
    - First we find the upper bound of the array and since we are given that accessing the out of bound 
    gives the max value, we can leverage that by putting in while condition
    - While arr.get(ele) < target
        Increment hi = hi * 2
    - Update lo = hi / 2 , since we already have surpassed the region where target is not found
    - Run binary search with lo and hi
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        hi = 1
        size = 0
        while reader.get(hi) < target:
            hi = hi << 1
        lo = hi >> 1

        while lo <= hi:
            mid = (lo + hi) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                hi = mid - 1
            else:
                lo = mid + 1
        
        return -1