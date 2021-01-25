"""Search in Infinite sorted array"""

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        high = 1 
        while reader.get(high) <= target:
            if reader.get(high) == target:
                return high
            high = high * 2
        
        return self.BinarySearch(0,high,target,reader)
    
    def BinarySearch(self,low,high,target,reader):
        while(low <= high):
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif (reader.get(mid) < target):
                low = mid + 1
            else:
                high = mid - 1 

        return -1
        