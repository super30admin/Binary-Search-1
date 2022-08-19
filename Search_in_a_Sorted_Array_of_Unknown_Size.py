# Version 1
# Time complexity : O(logn)
# Space Complexity : O(1)
# Yes it ran successfully on leetcode
# Any problems faced? Nothing major



# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        max_value = (2**31)-1
        i = 0
        j = 10000
        while i <= j:
            k = (i+j)//2
            val = reader.get(k) 
            
            if val == target:
                return k
            elif val == max_value:
                j = k-1
            elif target < val:
                j = k-1
            else:
                i = k +1
        return -1
            
