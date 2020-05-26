#Leetcode 702 : Search in a Sorted Array of Unknown Size
#Time Complexity : O(logn) [for both, binarySearch() and getRange()]
#Space Complexity : O(1)

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


#This is the leetcode version of the question. Instead of using the reader, we can simply do arr[index] to get the value.
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low,high = self.getRange(reader,target)
        return self.binarySearch(low,high,target,reader)
    
    def binarySearch(self,low,high,target,reader):
        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def getRange(self,reader,target):
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2 * high
        return [low,high]