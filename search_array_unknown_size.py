# O(LOG(N)) TIME AND O(1) SPACE WHERE N IS LEN(ARRAY)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        low,high = self.getBoundaries(reader,target)
        print(low)
        print(high)
        while low <= high:
            mid = (low+high)//2
            if reader.get(mid) == target:
                return mid
            if target < reader.get(mid):
                high = mid - 1
            else:
                low = mid + 1
        return -1 
            
    def getBoundaries(self,reader,target):
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2
        return (low,high)