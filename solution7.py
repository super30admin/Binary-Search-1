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
        while(0<=i<pow(10,4)):
            num=reader.get(i)
            if num==target:
                return i
            i=i+1
        return -1