# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        #check base case
        if reader.get(0) == target:
            return 0
        if reader.get(0) > target:
            return -1 

        #setting pointers
        l,r = 0,1

        #check value at right pointer to increase search space
        while reader.get(r) < target:
            r *= 2
        

        while l <= r:
            mid = l + (r - l) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            
            #updating pointers as per it's position with mid value
            elif val > target:
                r = mid - 1
            else:
                l = mid + 1
        
        #return if search fails
        return -1

        
#------------------------------------------------------------------------------------------------------------------------
# Time complexity: O(logn)