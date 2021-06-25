#brute force
#time-comp-O(n) it will go maximum till we find greater element than target.
#space comp-O(1)
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
        i=0
        while True:
            curr=reader.get(i)
            if curr==target:
                return i
            elif curr>target:
                return -1
            i=i+1
            
            
            
        
