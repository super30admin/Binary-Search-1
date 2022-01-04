# // Time Complexity :O(lognk), logn+logk , logn bcoz serach space increase by 2 each time, k is the size of the range where element is present
# // Space Complexity :O(1)
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
        l=0
        h=1
        
        while target>reader.get(h):
            print(reader.get(h))
            print(l,h)
            l=h
            h=2*h
        print(l,h)
        while l<=h:
            mid=(l+h)//2
            
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)<target:
                l=mid+1
            else:
                h=mid-1
        return -1