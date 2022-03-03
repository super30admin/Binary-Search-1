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
        # Time Complexity = O(log n)
        # Space Complexity = O(1)
        
        # for(i=n; i>=1; i=i/2)
        # for(i=1; i>=n; i=2*1)

        start = 0
        end = 1
        
        while start <= end:
            mid = (start+end) //2
            if reader.get(start) == target:
                return start
            elif target > reader.get(mid):
                start = mid+1
                end = 2*start
            else:
                end = mid-1
        return -1
                
            
            
        