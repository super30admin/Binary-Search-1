# 1 3 5 7 10 11 16 20 23 30 34 60
# 0 1 2 3 4 5   6. 7.  8 9  10 11
# 5 --> row = 0, col = 2. 2%4 = 2, 2//4 = 0
# 16 --> row = 1, col = 2, 6%4 = 2, 6//4 = 1 
# Convert the 2D matrix to 1D matrix by adjusting the indices, row = mid//n and col = mid%n. Do the normal binary search now - TC - O(log(mn)), SC- O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m*n-1
        while low<=high:
            mid = low+(high-low)//2
            row = mid//n
            col = mid%n
            if matrix[row][col] == target:
                return True
            elif target < matrix[row][col]:
                high = mid-1
            elif target > matrix[row][col]:
                low = mid+1
        return False

            

        

        