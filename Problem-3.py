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
# Time Complexity : O(logn)
        #Space Complexity :O(1)
        #Did this code successfully run on Leetcode :Yes
        #Any problem you faced while coding this : No

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low=0
        high=1
        while(reader.get(high)<target):
            low=high
            high*=2
        #print(low)
        return self.BinarySearch(reader,target,low,high)
    
    def BinarySearch(self,reader,target,low,high):
        while(low<=high):
            mid=low+(high-low)//2
            if(reader.get(mid)==target):
                return mid
            elif(reader.get(mid)<target):
                low=mid+1
            else:
                high=mid-1
        return -1
        
        
        