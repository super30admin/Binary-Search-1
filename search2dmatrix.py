# Time Complexity : O(n+log(m))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i = 0
        j = len(matrix[i])-1
        if len(matrix)==1:
            return self.searchRow(matrix[i],target)
        else:   
            while(i < len(matrix)):
                element = matrix[i][j]
                if element == target:
                    return True
                elif target < element:
                    return self.searchRow(matrix[i],target)
                else:
                    i = i + 1
            
    def searchRow(self, row: List[int],target:int)->bool:
        low = 0
        high = len(row)-1
        while(low <= high):
            mid = (low + high)//2
            if row[mid] == target:
                return True
            elif target > row[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return False            
            