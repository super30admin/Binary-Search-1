# Time Complexity: O(log(n)), n is the number of elements in the hidden array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach in three sentences only
"""
# Start by expanding the search range exponentially until the target is within the range.
# Once the range is identified, perform a regular binary search to find the target.
# This method works efficiently even when the array size is unknown.
"""


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high *= 2
        
        while low <= high:
            mid_index = low + (high -low) // 2
            mid_element = reader.get(mid_index)

            if mid_element == target:
                return mid_index
            elif mid_element > target:
                high = mid_index - 1
            else:
                low = mid_index + 1
        
        return -1
