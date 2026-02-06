# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No
# Approach: First, exponentially expand the search window until the target is within range.
# Then apply binary search within that range. 

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        # Expand range exponentially
        while reader.get(high) < target:
            low = high
            high *= 2

        # Binary search within range
        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
