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
        def search(reader,l,r):
            while l<=r:
                mid = l + int((r - l)/2)
                if target == reader.get(mid):
                    return mid
                elif target > reader.get(mid):
                    l = mid + 1
                else:
                    r = mid - 1
            return -1
        
        if reader.get(0) == target:
            return 0
                    
        l = 0
        r = 1
        while reader.get(r) < target:
            l = r
            r = r*2
        print(l, r)    
        return search(reader,l, r)    
