# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time - O(log n)
# space - O(1)

class Solution:
    #print(ArrayReader(get(3)))
    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        while(low <= high):
            mid = low + (high-low)//2
            x = reader.get(mid)
            if(x == target):
                return mid
            elif(target < x):
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low = 0
        high = 1
        
        while(reader.get(high) < target):
            low = high
            high = 2*high
            
        return self.binarySearch(reader, target, low, high)
    
    