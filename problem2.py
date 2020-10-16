# Time Complexity : O(logn)
# Space Complexity :O(1)
# problem in finding the time and space complexity
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
        #binary search
        l=0
        r=1
        while(target>reader.get(r)):# checking target is greater then r
            l=r
            r=2*r# increasing right part by 2


        while (l<=r):
            mid=l+(r-l)//2
            if reader.get(mid)==target:
                return mid
            if target>reader.get(mid):
                l = mid+1
            else:
                r=mid-1
        return -1


        """
        linear search
        i=0
        while reader.get(i)!=2147483647:
            if target==reader.get(i):
                return i
            else:
                i +=1
        return -1
        """
