# Time Complexity : O(log n) + O(log n) //first to find the upper bound, r, then to find the number inside the range (l, r)
# Space Complexity : O(log n) for the binary search call stack I guess 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
# since array size is unkown we dont know the length to do a binary search, so we first do a doubling of thr upper bound which could contain target
# then we just do a binary search to see if target exists in this range or not
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
        l = 0
        r = 1
        
        while(reader.get(r)<target):
            l = r
            r = r*2
        
        return self.binarySearch(reader, target, l, r)
    
    def binarySearch(self, reader, target, l, r):
        if(l>r):
            return -1
        
        mid = l+(r-l)//2

        if(reader.get(mid)==target):
            return mid
        if(reader.get(mid)<target):
            return self.binarySearch(reader, target, mid+1, r)
        return self.binarySearch(reader, target, l, mid-1)