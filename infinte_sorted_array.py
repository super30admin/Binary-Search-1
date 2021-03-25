# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        low=0
        high=1
        while target>reader.get(high):
            high=high*2
        while low<=high:
            mid =(low+high)//2
            if reader.get(mid)==target:
                return mid
            else:
                if reader.get(mid)<target:
                    low=mid+1
                else:
                    high=mid-1
        return -1
        
            