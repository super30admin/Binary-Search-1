# Search in Infinite sorted array:
# Given a sorted array of unknown length and a number to search for,
# return the index of the number in the array. Accessing an element out of bounds throws exception.
# If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

# // Time Complexity : logn+logn == logn
# // Space Complexity :
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right = right * 2

        while left <= right:
            mid = int(left + (right - left) / 2)
            if reader.get(mid) == target:
                return mid
            if target < reader.get(mid):
                right = mid - 1
            else:
                left = mid + 1
        return -1