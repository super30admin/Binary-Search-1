# Since the rows and columns are sorted and the last element in the any row is always smaller than the first element in the next row,
# the 2D array can be visualized as a 1D array. We can calculate the corresponding middle element's indices and then perform Binary search
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return -1
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n - 1
        while (low<=high):
            mid = low + (high-low)//2
            row = mid//n
            col = mid%n
            if (matrix[row][col]==target):
                return True
            elif (matrix[row][col]>target):
                high = mid-1
            else:
                low = mid+1
        return False

#Time Complexity: O(log M) + O(log N)
#Compiled in Leetcode