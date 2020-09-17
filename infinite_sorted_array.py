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
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : This problem is returning null on Leetcode.
Can you help me understand the issue? Thanks.
"""


class InfiniteSortedArray():
    # Function to search number in infinite sorted array
    def infinite_search(self, reader, target):
        # to check the first element in the array
        if reader.get(0) == target:
            return 0

        # Search boundaries
        left = 0
        right = 1
        while reader.get(right) < target:
            left = right
            right = right * 2
        self.binarySearch(reader, target, left, right)

    # Function for Binary Search
    def binarySearch(self, reader, target, left, right):
        # Base case
        if left > right:
            return -1

        # while left <= right:
        mid = int(left + (right - left)/2)
        num = reader.get(mid)

        if num == target:
            return mid
        elif num > target:
            return self.binarySearch(reader, target, left, mid - 1)
        else:
            return self.binarySearch(reader, target, mid + 1, right)
