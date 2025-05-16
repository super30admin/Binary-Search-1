"""
Time Complexity: O(log n)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Expands the search boundary exponentially until the target is within range,
# then performs binary search.
"""

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        if reader.get(0) == target:
            return 0
        
        low , high = 0 , 1

        while reader.get(high) < target:
            low = high
            high = high * 2
        
        while low <= high:
            mid_idx = low + ((high - low) // 2)
            result = reader.get(mid_idx)

            if result == target:
                return mid_idx
            if result > target:
                high = mid_idx - 1
            else:
                low = mid_idx + 1
        return -1
        