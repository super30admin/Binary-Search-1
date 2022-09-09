# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
'''
Time Complexity: O(logn)
Space Complexity: O(1)
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1
        while(l<=r):
            mid = int((l+r)/2)
            if(reader.get(mid)==target):
                return mid
            if(target>reader.get(r)):
                l = r
                r = r*2
            elif(reader.get(mid)<target and reader.get(r)>=target):
                l = mid+1
            elif(reader.get(mid)>target and reader.get(l)<=target):
                r = mid-1
            else:
                break
        return -1
        