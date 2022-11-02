'''
Time Complexity
O(logn)

Space Complexity
O(1) constant

Approach
1. Assume a 2d array as a 1D array with low index = 0 and high index = m*n-1
2. Have a mid = (low+high)/2
3. Row = mid//n and Col = mid%n
4. Perform Binary Search and return True if found else return False

'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        if target<matrix[0][0] or target>matrix[m-1][n-1]:
            return False
        low = 0
        high = (m*n)-1
        while low<=high:
            mid = (high+low)//2
            row = mid//n
            col = mid%n
            if target==matrix[row][col]:
                return True
            elif target>matrix[row][col]:
                low = mid+1
            else:
                high = mid-1
        return False
        