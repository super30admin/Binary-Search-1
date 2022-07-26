# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
#executed in leet code
#Time complexity -O(logT)
#space complexity - O(log1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        low,high=0,1
        while reader.get(high) < target:
            low = high
            high = high * 2
        while low <=high :
            mid = low + ((high -low) // 2)
            temp = reader.get(mid)
            if temp == target:
                return mid
            if temp > target:
                high = mid-1
            else:
                low = mid+1
        return -1
            
        