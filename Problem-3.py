# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


"""
Approach:
The goal is to increase our search space by a factor of 2 everytime and then run a binary search
1) begin with first 2 elements
2) find boundaries such that the target lies within
    a) Keep increasing your higher boundary by 2 everytime
    b) in case your search index goes out of range, the reader api handles it by returning int_max
3) once we have the boundary fixed we try to find the target with binary search
    a) Either the target is present, return the index in this case
    b) else return 1

"""
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        low = 0
        high = 1

        while target > reader.get(high):
            low = high
            high = 2 * high
        return self.binary_search(reader, low, high, target)

    def binary_search(self, reader, low, high, target):

        while low <= high:

            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid

            elif reader.get(mid) < target:
                low = mid + 1

            else:
                high = mid - 1

        return -1

"""
Time Complexity: O(log n) since we are doubling our search space everytime

Space Complexity: O(1)
"""