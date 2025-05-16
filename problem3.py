#t.c. => O(log(n)) n is the index of target
#s.c. => O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : Initilally implemented using r=(10^4-1) using the contraint given. But then took a hint from solution saying l=0,r=1 and got the idea for the approach interviewer might expect for this problem.
#approach => initially start with (0,1)=>(l,r) search space and expand r twice(logarithmically) till either r is outofbounds or nums[r] > target
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binSearch(self, reader, l, r, target):
        while l <= r:
            mid = l + (r - l)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                #if target < mid val or out ofbounds
                r =  mid - 1
        return -1

    def search(self, reader: 'ArrayReader', target: int) -> int:
        outOfBoundsVal = (2**31) - 1
        l, r = 0, 1
        if reader.get(r) == outOfBoundsVal:
            if reader.get(l) == target:
                return l
            return -1
        
        while True:
            val = reader.get(r)
            if val == outOfBoundsVal or target <= val:
                return self.binSearch(reader, l, r, target)
            l = r
            r = r << 1
        return -1
