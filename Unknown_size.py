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
        def b_search(l,r):
            print(l)
            print(r)
            if l<=r:
                mid = (l+r)//2
                if reader.get(mid)==target:
                    return mid
                if reader.get(mid)<target:
                    return b_search(mid+1,r)
                else:
                    return b_search(l,mid-1)
            else:
                return -1
        
        
        
        left=0
        right=1
        while(reader.get(right)<target):
            left=right
            right = right*2
        return b_search(left,right)
        
            