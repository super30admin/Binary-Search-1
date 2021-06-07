# Time Complexity: O(logn)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: 1. Find right end r, set left end to zero
# 2. Find target using binary search

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        r = 1
        while reader.get(r) < target:
            r <<= 1
        
        l = 0
        while l <= r:
            m = (l+r) // 2
            if reader.get(m) < target:
                l = m+1
            elif reader.get(m) > target:
                r = m-1
            else:
                return m
        
        return -1