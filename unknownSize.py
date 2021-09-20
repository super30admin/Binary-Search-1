class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start = 0
        end = 2
        
        while reader.get(end) < target:
            start = end
            end *= 2
        
        while start <= end:
            mid = (start + end)//2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1