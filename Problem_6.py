# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 24 ms Memory Usage: 14.5 MB
# Any problem you faced while coding this : No 
# Your code here along with comments explaining your approach
# Approach
"""
In this problem since array size is unknown i.e last_index is unknown and 
it is taken as MAXSIZE of int.In Binary Search list is divided into two halves after calculating the middle value
and than element/target is searched for. 
  
"""
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """
import sys
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        first_index=0
        last_index=sys.maxsize - 1 # Initializing Last index as MAXSIZE of int
        while (first_index<=last_index):
            middle=(first_index+last_index)//2 # Calculating middle value
            if(target==reader.get(middle)):
                return middle
            else:
                if(target>reader.get(middle)): # Checking in right half
                    first_index=middle+1
                else:
                    last_index=middle-1 # Checking in left half
        return -1      
         