#Time Complexity : The time complexity of this algorithm depends on how quickly it can find the upper bound of the search range. 
#The initial while loop doubles the high index until reader.get(high) becomes greater than or equal to the target. 
#This operation takes O(log n) time where n is the index where the target lies. After that, the regular binary search within 
#the range [low, high] takes O(log n) time. Therefore, the overall time complexity is O(log n), where n is the index where 
#the target lies.
#Space Complexity : O(1) as we do not use any extra space.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: Here since we dont have the size of array, we need to find the window in which the target lies. To find that we use 2
#pointers low and high. while value at high is less than the target we change the low pointer to high and double the high pointer.
#Once this while loops end that is when the value at high pointer is greater than the target, we get the window wherein the target lies.
#(between high and low pointer). Now we apply binary search within this window using low and high pointer.

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
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2*high
        while low <= high:
            mid = (low+high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1