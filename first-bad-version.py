# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if not n:
            return n
        
        start, end = 1, n
        
        while start <= end:  
            mid = start + (end - start) // 2
            if isBadVersion(mid):
                if mid == 0:
                    return mid
                if not isBadVersion(mid - 1):
                    return mid
                else:
                    end = mid - 1
                    continue
            else:
                start = mid + 1
                
        return 0
            
        
