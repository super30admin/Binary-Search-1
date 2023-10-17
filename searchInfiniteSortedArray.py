# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity : O(log n)
# Space Complexity : O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        left, right = 0, 1
        if reader.get(0) == target:
            return 0

        while left <= right:
            mid = (left + right) // 2
            midValue = reader.get(mid)
            if midIndex == (2 ^ 23) - 1 or midIndex > target:
                right = mid - 1
            elif midIndex == target:
                return mid
            elif midIndex < target:
                left = mid + 1
                right *= 2
        return -1
