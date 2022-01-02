# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

#Time Complexity  : O(logn)
# Space Complexity : O(1)

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        start = 0
        end  = 1
        
        # Iterate through the elements and get the range where the target is closer by moving the start and end based on target value
        while ( reader.get(end) < target) :
            start = end 
            end = end * 2
        
        # do binary search for the last elements that contains the target
        while (start <=  end) :
            mid = start + (end - start)// 2
            
            if reader.get(mid) ==  target :
                return mid
            
            elif reader.get(mid) > target :
                end = mid - 1
            else :
                start = mid + 1
                
        
        return -1
                
        