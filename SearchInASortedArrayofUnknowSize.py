// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# """
# This is ArrayReader's API interface.
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
        
        def binarysearch(low,high,target,reader):
            while low<=high:
                mid=low+(high-low)//2
                if reader.get(mid)==target:
                    return mid
                elif reader.get(mid)>target:
                    high=mid-1
                else:
                    low=mid+1
            return -1
        
        low=0
        high=1
        while(reader.get(high)!=2147483647): #searching for high by hitting the infinite
            high=high*2
        
        return binarysearch(low,high,target,reader) #searching for the target element