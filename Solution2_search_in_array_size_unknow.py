# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Algorithm
# Linear search takes O(N) in this case not good
# Optimized approach -Make the search space finite
# 1. Begin with start pointer as 0 
                   # and end pointer as 1
# 2. Increment the end pointer by multiplying with 2 till 
#    end pointer crosses target 
# 3. Do binary search with finite space and return index if 
#    present else return -1


# TC o(log(n))
# SC o(1)


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        s = 0
        e= 1
        
        if reader.get(s) ==target:
            return s
        
        while target >= reader.get(e):
            if target == reader.get(e):
                return e
            else:
                e=e+2*e
        
        while s<=e:
            mid=s+(e-s)//2
            
            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) < target:
                s=mid+1
            else:
                e=mid-1
        return -1
            