class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        m=len(matrix)
        n=len(matrix[0])
        
        low = 0
        high = m*n - 1
        
        while low<=high:
            mid = int(low+(high-low)/2)
            row = int(mid//n)
            column = int(mid%n)
            print(mid,row,column)
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] > target:
                high = mid-1
            else:
                low = mid+1
        return False