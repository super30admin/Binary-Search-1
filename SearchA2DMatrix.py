class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # dimensions of our matrix
        ROWS, COLS = len(matrix), len(matrix[0])
        # print(ROWS, COLS)
        
        # 1. Binary Search the matrix - to see in which row we can have our target 
        top = 0
        bottom = ROWS-1
        

        # here we find in which row is our target variable
        while top<= bottom:
            row = (top + bottom)//2
            if target > matrix[row][-1]:
                top = row+1
            elif target < matrix[row][0]:
                bottom = row-1
            else:
                break
        # print(top, bottom)
                
        # base conditiom
        if not(top<=bottom):
            return False
        
        # now we binary search our row to find if the target variable exists or no 
        row = (top + bottom)//2
        left, right = 0, COLS-1
        while left<=right:
            mid = (left+right)//2
            if target > matrix[row][mid]:
                left = mid + 1
            elif target < matrix[row][mid]:
                right = mid - 1
            else:
                return True
        return False
        
        
        # O(logm)*O(logn)