# Time Complexity: 
# O(log n)
# Space Complexity:
#  O(1), we use no extra space
# Did this code successfully run on Leetcode: 
# Yes
# Approach
# We first find a range [low, high] where the target can be by doubling the high index.
# Then we do binary search within this range to find the target.
# This helps us search in a sorted array of unknown (infinite) size efficiently.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        low, high = 0, 1

        # Step 1: Expand the range until reader.get(high) >= target
        while reader.get(high) < target:
            low = high
            high *= 2

        # Step 2: Binary search within the range
        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1
