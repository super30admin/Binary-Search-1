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
        def binarySearch(reader, target, start, end):
            if start > end: return -1
            while start <= end:
                mid = start + (end - start) // 2
                if reader.get(mid) == target: return mid
                elif reader.get(mid) < target: start = mid + 1
                else: end = mid - 1
            return -1
            
        slow, fast = 0, 1
        while reader.get(fast) <= target and reader.get(slow) <= target:
            slow = fast
            fast = 2 * fast
        return binarySearch(reader, target, slow, fast)
                
            
        
