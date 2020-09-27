"""
# Problem - Search in Infinite sorted array
    - (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
    - Given a sorted array of unknown length and a number to search for,
    return the index of the number in the array.
    - Accessing an element out of bounds throws exception.
    - If the number occurs multiple times, return the index of any occurrence.
    - If it isn’t present, return -1.
Solution - Recursive approach
    - Define search boundaries
    - Perform Binary Search
Time Complexity - O(log n), where n is the index of target value
Space Complexity - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # Base case
        if reader.get(0) == target:
            return 0

        # search boundaries
        left = 0
        right = 1
        while reader.get(right) < target:
            left = right
            right = right * 2
        return Solution.binary_search(reader, target, left, right)

    def binary_search(reader, target, left, right):
        while left <= right:
            mid = left + (right - left) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1



