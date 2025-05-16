# // Time Complexity : o(logm) to find the range and then o(logk) to apply binary search on the search space but it is o(log(n)) where n is index of the target 
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
# could develop the orignal solution by finding the upper bound for seasrch starting from 1 to exponentially increasing but couldnt optimie as taught in lecture 


# // Your code here along with comments explaining your approach in three sentences only
# 1) find the search space or upper bound by exponentially increasing size startign from 1 and stopping when target is in range 
# 2) for optimization keep moving the low with r (upper bound ) till we are executing while 
#3) once we find upper and lower apply binary search to search the element

# Approach 1
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# class Solution:
#     def search(self, reader: 'ArrayReader', target: int) -> int:
#         l ,r = 0,1
#         if reader.get(r) == target:
#             return r
        
#         while reader.get(r) < target:
#             r*=2
        
#         while l<=r:
#             mid = (l+r)//2
#             if reader.get(mid) > target:
#                 r = mid -1
#             elif reader.get(mid) < target:
#                 l = mid +1
#             else:
#                 return mid
#         return -1

# Approach 2: optimized
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l,h = 0,1
        while reader.get(h) < target:
            l = h
            h*=2
        while l<=h:
            mid = l + ((h-l)//2)
            if target == reader.get(mid):
                return mid
            elif target > reader.get(mid):
                l = mid+1
            else:
                h = mid-1
        return -1

        
        