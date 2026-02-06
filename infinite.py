# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, expand the search range exponentially until the target must lie within [low, high].
# Then perform a binary search within that range to locate the target.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + ((high - low) // 2)

            if reader.get(mid) == target:
                return mid
            elif reader.get(low) <= target and reader.get(mid) >= target:
                high = mid - 1
            else:
                low = mid + 1

        return -1