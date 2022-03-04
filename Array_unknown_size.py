# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high = high*2
            
        while low <= high:
            mid = low + (high - low)//2
            
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                
                high = mid - 1
            else:
                low = mid + 1
                
        return -1
            
            