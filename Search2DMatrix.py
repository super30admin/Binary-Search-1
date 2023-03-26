#Time Complexity: O(log(m*n))
#Space Complexity: O(1)
#Approach : Traverse a 2D array and implement binary search.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or matrix[0] == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1

        while low<=high:
            mid = (low + high) // 2
            row, col = divmod(mid, n)

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
            
        return False