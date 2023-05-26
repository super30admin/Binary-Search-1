"""
Problem : 8
Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

first finding the actual range of the reader to search for target
then performing traditional binary search on the given range in reader
"""

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

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        size=1
        while reader.get(size-1)<target:
            size*=2
        
        r=size-1
        l=size//2
        
        while l<=r:
            mid=(l+r)//2
            if target>reader.get(mid):
                l=mid+1
            elif target<reader.get(mid):
                r=mid-1
            else:
                return mid
        return -1
    
# Another Approach



# class Solution(object):
#     def search(self, reader, target):
#         """
#         :type reader: ArrayReader
#         :type target: int
#         :rtype: int
#         """
#         l=0
#         r=1
#         while reader.get(r)<target:
#             l=r
#             r*=2
        
#         while l<=r:
#             mid=l+(r-l)/2
#             if reader.get(mid)==target:
#                 return mid
#             elif reader.get(mid)>target:
#                 r=mid-1
#             else:
#                 l=mid+1
#         return -1