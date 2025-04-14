# """
# This is ArrayReader's API interface.
# Time Complexity : O(logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no 


# Your code here along with comments explaining your approach


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
        
        low=0
        high=1
        
        #Decide the bounds in the infinite array to search the element
        while reader.get(high)<=target:
            low=high
            high=high*2


        # perform binary search on those array bounds
        return self.binarySearch(reader,low,high,target)
        
    
    def binarySearch(self,reader,low,high,target):
        
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
        
        return -1
        