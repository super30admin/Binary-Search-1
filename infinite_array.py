# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems but it took me more around 45 mins to do this
# which is not good I think


# Your code here along with comments explaining your approach
# I find the length first by doubling a variable starting at 1. Everytime I overflow I half the variable add 1
# and start doubling again adding the new value to the previous legal value. Once I have the length, I use 
# binary search

#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        x = 1
        m = 1
        length = None
        while reader.get(x+1) != 2147483647:
            while reader.get(x+m) != 2147483647:
                m *= 2
            x = x + int(m / 2)
            m = 1
        return self.bin_search(reader, 0, x, target)
        
    
    def bin_search(self, reader, start, end, target):
        if start < end:
            mid = start + math.floor((end - start) / 2)
            if reader.get(mid) > target:
                return self.bin_search(reader, start, mid-1, target)
            elif reader.get(mid) < target:
                return  self.bin_search(reader, mid+1, end, target)
            else:
                return mid
        else:
            if reader.get(start) == target:
                return start
            return -1
