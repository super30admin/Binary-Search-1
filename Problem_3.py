"""
Time Complexity : O(log(n)) 
Space Complexity : O(1)

"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l = 0
        h = 1
        
        
        while reader.get(h) < target:
            l = h
            h = h*2
        
        while h >= l:
            mid = l + (h-l)//2
            print(mid)
            
            if reader.get(mid) == target:
                print(mid)
                return mid 
            
            elif reader.get(mid) < target:
                l = mid + 1 
                
            else:
                h = mid - 1 
                
        return -1 