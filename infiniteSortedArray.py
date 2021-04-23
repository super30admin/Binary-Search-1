# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        
        low = 0
        high = 1
        
        while target>reader.get(high):
            low = high
            high *= 2
        
        while low<=high:
            mid = (low + high)//2
            
            if target == reader.get(mid):
                return mid
            
            elif target<reader.get(mid):
                high = mid -1
                
            else:
                low = mid +1
        
        return -1
        
#        time and space complexity - time complexity is n+log(n) as we are doing binary search and also doing shifting of elements to find the high

# the high end is to be found here - we first invest time in finding high by doubling it till its more than target.
# Once found, we have low and high, just apply simple binary search there after.
        
        
        
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
