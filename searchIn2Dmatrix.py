# Time Complexity : O(log(mn)) for the first and log(m) + log(n) for the second
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I often get myself confused with >,<,% because of the language
# differences. I took whole 2 days to complete binary search 1. i had debugger open for every single time 
# and also manually doing it on whiteboard.


from typing import List
import math

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix == None or not matrix): return False
        m,n = len(matrix), len(matrix[0])
        low, high = 0, m * n - 1
        while(low <= high):
            mid = (low + high) // 2
            r = mid // n 
            c = math.floor(mid % n)
            if matrix[r][c] == target: return True
            elif matrix[r][c] > target: 
                high = mid - 1
            else:
                low = mid + 1 
                
        
    def searchMatrix2(self, matrix: List[List[int]], target: int) -> bool:
        # solution 2 with time complexity log(m) + log(n) binary search on row first then column
        if matrix == None or not matrix: return False 
        high, low = len(matrix) - 1,0
        if matrix[high][0] == target or matrix[low][0] == target: return True
        indexOfRowWithTarget = 0
        breaktheloop = False
        if high == low: breaktheloop = True
        # finding the row which contains our target value
        while low <= high and not breaktheloop:
            mid = (high + low) // 2
            if matrix[mid][0] == target: return True
            while matrix[mid][0] < target:
                if matrix[mid + 1][0] > target:
                    indexOfRowWithTarget = mid + 1
                    breaktheloop = True
                    break
                else:
                    high = mid - 1
            while matrix[mid][0] > target:
                if matrix[mid - 1][0] < target:
                    indexOfRowWithTarget = mid - 1
                    breaktheloop = True
                    break
                else:
                    low = mid + 1
        # finding out which column contains our target value
        low,high = 0, len(matrix[indexOfRowWithTarget]) - 1
        if matrix[indexOfRowWithTarget][high] == target: return True
        while low <= high:
            mid = (low + high) // 2
            if matrix[indexOfRowWithTarget][mid] == target: return True
            while matrix[indexOfRowWithTarget][mid] < target:
                high = mid - 1
                break
            while matrix[indexOfRowWithTarget][mid] > target:
                low = mid + 1
                break
                
        return False
    
        
findmat = Solution()
print(findmat.searchMatrix([[1,3]], 0))
print(findmat.searchMatrix([[1]], 1))
print(findmat.searchMatrix([[1,3]], 3))