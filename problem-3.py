# Time complexity is O(log n) and space complexity is O(1)
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
# Initializing the start and end indices       
        start = 0
        end = 1
# Checking if target is not greater than the end element
        while reader.get(end) < target and reader.get(end) < float('inf'):
# Incrementing end pointer by 2 times each time        
                start = end
                end = 2*end
# Applying binary search            
        while start <= end:
            mid = start + (end-start)//2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                start = mid+1
            else:
                end = mid-1
        return -1