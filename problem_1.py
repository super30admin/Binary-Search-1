# Time complexity: O(log(m*n))
# Space complexity: O(1)


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        columns = len(matrix[0])
        left = 0
        right = rows* columns - 1 
        
        while left <= right: 
            mid = (left+ right)//2 
            row = mid // columns 
            column = mid % columns
            if matrix[row][column] == target: 
                return True 
            elif matrix[row][column] > target :
                right = mid - 1 
            else : 
                left = mid+1 
        return False 
