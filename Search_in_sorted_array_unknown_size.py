# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l=0
        h=1
        while(target>reader.get(h)):
            l=h
            h=h*2
        while l<=h:
            mid=l+(h-l)//2
            if reader.get(mid)==target:
                return mid
            elif target>reader.get(mid):
                l=mid+1
            else:
                h=mid-1
        return -1
        

