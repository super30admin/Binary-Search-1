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

'''// Time Complexity : logn+logm
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach'''
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low = 0
        high = 1
        
        # First find the range
        while(reader.get(high)<target):
            low=high
            high=2*high
            
        #Implementing normal Binary Search
        while ( low <= high):
            mid=low+(high-low)/2
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                    high=mid-1
            else:
                low=mid+1
        return -1
        
