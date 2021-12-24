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
        #setting low and high on index 0 and 1
        low = 0
        high = 1

        while(reader.get(high) < target):
            low = high + 1 
            high = high * 2 #incrementing high twice

        while high >= low: 
            mid = (low+high) // 2
            if(reader.get(mid) == target): #if mid is equal to target return mid
                return mid
            elif(reader.get(mid) > target): # else if mid greater than target check on the left side 
                high = mid - 1
            else:
                low = mid + 1 #else check on the right side

        return -1
