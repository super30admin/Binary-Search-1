# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Brute Force
        # Time complexity: O(n)
        # Space Complexity:O(1)
        # for i in range(10**4):
        #     n = reader.get(i)
        #     if n == target:
        #         return i
        #     elif n == 2**31 - 1:
        #         return -1

        # Optimal Solution
        # Time complexity: O(log m*k)
        # Space Complexity:O(1)
        low = 0
        high = 1
        while reader.get(high) != (2 ** 31 - 1):
            if reader.get(high) < target:
                low = high
                high = high * 2
            elif reader.get(high) == target:
                return high
            else:
                break

        while low <= high:
            mid = int(low + ((high - low) / 2))
            if reader.get(mid) < target:
                low = mid + 1
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                return mid
        return -1
