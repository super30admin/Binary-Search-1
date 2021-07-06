"""
// Time Complexity : o(log n), where n  is the number of elements 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
# """
#
# 
#  This is ArrayReader's API interface.
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

        #idea is to find a range where the target value will lie
      
        l = 0 
        r = 1 #since size is unknown, we start from the first index to find the range

        while reader.get(r) < target: # loop will run until the value present at the right end is smaller than the target value, target value will lie in that range
            
            l = r # l is updated to previous r value, so that the range isn't too big each time
            r = r*2 # r is doubled everytime, wider range is captured
        
        while l <= r: # apply binary search in the subarray obtained
            mid = l + (r - l)//2
            
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1 #if not found