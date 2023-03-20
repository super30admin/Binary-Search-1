
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# time complexity - O(logn)
# space complexity - O(1)


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start=0
        end=1
        while(reader.get(end)<target):
            start=end
            end*=2

        while(start<=end):
            mid=start+(end-start)//2
            if reader.get(mid)<target:
                start+=1
            elif reader.get(mid)>target:
                end-=1
            else:
                return mid
        return -1
