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

# Time complexity is O(logN), where N is the target
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        def binarySearch(low,high,target,reader):
            while(low <= high):
                mid = (low+high)//2
                if(reader.get(mid) == target):
                    return mid
                elif(target < reader.get(mid)):
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        low = 0
        high = 1
        while(target > reader.get(high)):
            low = high
            high = 2*high
        return binarySearch(low,high,target,reader)