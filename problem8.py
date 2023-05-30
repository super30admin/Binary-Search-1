#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # Binary Search
        row, col = len(matrix), len(matrix[0])
        i, j = 0, (row * col) - 1

        while i <= j:
            mid = (i + j) >> 1
            mid_element = matrix[mid // col][mid % col] 
            if mid_element == target:
                return True
            elif mid_element < target:
                i = mid + 1
            else:
                j = mid - 1
        return False
        