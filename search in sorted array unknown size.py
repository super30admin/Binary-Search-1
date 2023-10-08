# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

#TC:log(T), T is index of target value
#SC: O(1)
#LC: runs yes, 702
#problems: NA
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high = 2*high
        while low <= high:
            mid = low + (high-low)//2
            value = reader.get(mid)
            
            if value == target:
                return mid
            if value > target:
                high = mid - 1
            if value < target:
                low = mid + 1
        return -1 
        
#TC: O(logn) to the base 98
#SC: O(1)
#LC: runs yes, 702
#problems: NA

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        low = 0
        high = 2**31 - 1
        
        while low <= high:
            mid = low + (high-low)//2
            value = reader.get(mid)
            
            if value == 2**31 - 1:
                high = mid - 1
            if value == target:
                return mid
            if value > target:
                high = mid - 1
            if value < target:
                low = mid + 1
        return -1