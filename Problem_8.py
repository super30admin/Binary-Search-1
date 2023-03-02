# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity : O(log n)
# Space Complexity : O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        if target == reader.get(0):
            return 0

        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = left + (right - left) // 2

            if target == reader.get(mid):
                return mid
            elif target > reader.get(mid):
                left = mid + 1
            else:
                right = mid - 1
        return -1