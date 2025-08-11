class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Have initialized the search range
        low, high = 0, 1

        # Have expanded the search range exponentially until the target is within range
        while reader.get(high) < target:
            low = high
            high *= 2

        # Now performing a binary search within this identified range
        while low < high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        # And checking if the target is at the final low index
        if reader.get(low) == target:
            return low
        return -1

# Time Complexity: O(log N), Since binary search.
# Space Complexity: O(1), only a constant amount of extra space is used.

        
