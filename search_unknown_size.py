# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """


# Using Binary Search Property Increasing the search space to get the target in unknown array size
# TC: O(log n) search space gets increased exponentially hence log k and for Binary search log n that makes O(log k + log n) log k <<<< log n
# SC: O(1) no extra space
class ArrayReader:
    def get(self, index: int) -> int:
        pass


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high *= 2

        while low <= high:
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
