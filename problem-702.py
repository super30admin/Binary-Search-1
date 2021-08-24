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

class Solution(object):
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
            high = high * 2
            
            
        while(low<=high):
            mid = (low + high) //2
            if(reader.get(mid) == target):
                return mid
            
            elif(reader.get(mid) > target):
                high = mid - 1
                
            else:
                low = mid + 1
                
        return -1
        