# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 0, 1

        # Find a range containing target
        while reader.get(right) < target:
            left = right
            right *= 2

        # Binary Search
        while left <= right:
            mid = (left + right) // 2
            num = reader.get(mid)

            if num == target:
                return mid
            elif num < target:
                left = mid + 1
            else:
                right = mid - 1

        return -1
