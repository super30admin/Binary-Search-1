# Time Complexity : O(log(n)) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySearch(self,reader,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2
            if reader.get(mid)==target:
                return mid
            
            if target<reader.get(mid):
                high = mid-1
            else:
                low= mid+1
        return -1
    
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low,high = 0,1
        
        while target>reader.get(high):
            low = high
            high = high*2
        result = self.binarySearch(reader,low,high,target)
        return result
    
    