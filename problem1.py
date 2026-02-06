class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        low = 0 
        high = (m*n) -1
        while(low <= high):
            mid = low + (high-low)//2
            row_ptr = mid//n 
            col_ptr = mid%n
            if matrix[row_ptr][col_ptr] == target:
                return True 
            elif matrix[row_ptr][col_ptr] > target:
                high = mid-1 
            else:
                low = mid+1
        return False