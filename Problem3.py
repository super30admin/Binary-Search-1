# Problem 3 : Search in a Sorted Array of Unknown Size
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
'''
None
'''
# Your code here along with comments explaining your approach in three sentences only

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        # Search the range where the target can be 

        # set the low to 0 and high to 1
        low  = 0
        high = 1
        # loop till the value at high poistion is less than target
        while (reader.get(high) < target):
            # set the low to high
            low = high
            # increment high to 2*high
            high = 2 * high
        
        # after getting range to search then use binary search to find the target
        # loop till low <= high
        while (low <= high):
            # find middle element
            mid = low + (high-low) // 2
            # if the value at middle poistion is equal to target
            if reader.get(mid) == target:
                # if it is then return middle ie index
                return mid
            # if the value is greater than target
            elif (reader.get(mid) > target):
                # set high to middle - 1
                high = mid - 1
            else:
                # else set low to middle + 1
                low = mid + 1
        
        # if the target is not found then return -1
        return -1