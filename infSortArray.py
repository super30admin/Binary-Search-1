"""
run time OlogN
Time complex: O1

search array of unknown length
"""
"""

Time: OlogN
space: O1
"""

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        
        end = 1
        
        while reader[end] < target:            
            end *= 2
            
            
        start = 0
        
        while start + 1 < end:
            
            mid = start + (end - start) // 2
            
            if reader[mid] == target:
                return mid
            elif reader[mid] < target:
                start = mid
            else:
                end = mid
                
        
        if reader[start] == target:
            return start
        
        if reader[end] == target:
            return end
        
        return -1

secret = [-1,0,3,5,9,12]
target = 3

obj = Solution()

print(obj.search(secret,target))