# Time Complexity : O(log(mn))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def searchMatrix(self, matrix, target):
        if len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n) - 1
        while low <= high:
            mid = low + (high - low)//2
            col = mid % n
            row = mid // n
            if matrix[row][col] == target:
                return True
            elif target < matrix[row][col]:
                high = mid -1
            else:
                low = mid + 1
        return False
        
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """



obj = Solution()
output1 = obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3)
print(output1)
output2 = obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13)
print(output2)
output3 = obj.searchMatrix([[1]],0)
print(output3)