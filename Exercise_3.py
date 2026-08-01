# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/

# Time complexity: O(log n)
# Space complexity: O(1)

# Explanation: Perform two operations. First find the possible range of the array to search, by doubling the search space in each iteration.
# Then run a regular binary search.

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
    
        l, h = 0, 1
        while reader.get(h) < target:
            l = h
            h = 2 * h
        
        while l <= h:
            mid = l + (h - l) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            if val > target:
                h = mid - 1
            else:
                l = mid + 1
        
        return -1
        
