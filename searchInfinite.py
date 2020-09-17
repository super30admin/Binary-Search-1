"""
// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        # Keep expanding our window using (low, high).
        # Because the array is already sorted, we need to only expand our window till the last element is greater than the element
        h = 1
        low, high = 0 , 0
        while(reader.get(high) < target):

            high = h*2
            h += 1

        # Once, our ceiling is found, take them as bounds and perform regular binary search.
        # This time with .get()
        while(low <= high):
            mid = (low + high) // 2
            if(reader.get(mid) == target):
                return mid

            if(reader.get(mid) > target):
                high = mid - 1
            else:
                low = mid + 1

        # Return -1 if nothing is found.        
        return -1
