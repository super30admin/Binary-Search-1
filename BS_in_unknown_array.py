#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach
# # """
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
        low=0   # start from low index of 0
        high=1  # let the high index be 1

        while reader.get(high)<target: # target is still not in range 
            low=high                   # low becomes high
            high=high*2                # high becomex twice the previous index
        
        while low<=high:              # do binary search once the range of the target is reached 
            mid=low+(high-low)/2      # get the mid value
            if reader.get(mid)==target: # check if the mid value is the target
                return mid              #return the index
            if reader.get(mid)>target:  # check if the target is in the left range 
                high=mid-1              # change high to lesser than mid 
            else:
                low=mid+1               # if the target is the right range change low to higher than mid 
        
        return -1                       # if out of loop target not present
        