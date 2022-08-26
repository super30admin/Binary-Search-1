# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

#Time complexity O(log m + log n)
#Space Complexity O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # if reader.get(0)== target:
        #     return 0

        left = 0
        right = 1

        if reader.get(1) == target:
            return 1

        # setting boundaries
        while reader.get(right) < target:
            left = right
            right <<= 2

        # binary search
        while right >= left:
            pivot = left + ((right - left) >> 1)

            if reader.get(pivot) == target:
                return pivot

            if reader.get(pivot) > target:
                right = pivot - 1

            else:
                left = pivot + 1

        return -1



