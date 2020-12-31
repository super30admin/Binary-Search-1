'''
time complexity  O(logn)
space complexity O(1)
Approch : 
[0,1]
[1,2]
[2,4]
[4,8]
[8,16]
doubling the search space until we get the element greater than the target
the apply the binary-search on last window
'''
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l = 0
        h = 1
        while target > reader.get(h):
            l = h
            h = h * 2
            
        while l <= h:
            m= l + (h-l)//2
            mid = reader.get(m)
            if  mid== target: return m
            if  target <mid:
                h = m-1
            else:
                l = m+1
        return -1    
