# search in sorted array of unknown length
# Complexity: O(log(n))
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
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
        # max length 10^4
        def binarySearch(reader,target,beg,end):
            if(beg>end):
                return -1
            mid = (beg + end)//2
            num = reader.get(mid)
            if(num==target):
                return mid
            elif(num>target):
                return binarySearch(reader,target,beg,mid-1)
            else:
                return binarySearch(reader,target,mid+1,end)
        beg = 0
        end = 1
        while(target>reader.get(end)):
            beg = end
            end = end * 2
        return binarySearch(reader,target,beg,end)
        