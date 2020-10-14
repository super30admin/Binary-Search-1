# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Problem2:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        i=0
        while reader.get(i)!=2147483647:
            if target==reader.get(i):
                return i
            else:
                i +=1
        return -1
