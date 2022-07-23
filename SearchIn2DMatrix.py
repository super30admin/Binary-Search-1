'''
Time Complexity - O(log(m*n))
Space Complexity - O(1)
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n)-1
        while (low <= high):
            mid = low + (high-low)//2
            mid_num = matrix[mid//n][mid % n]
            if mid_num == target:
                return True
            elif mid_num > target:
                high = mid-1
            else:
                low = mid+1
        return False
