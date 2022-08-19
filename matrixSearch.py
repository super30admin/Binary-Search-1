#TimeComplexity - O(logn)
#space Complexity - O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        first, last = 0, rows * cols - 1
        
        while first <= last:
            mid = (first + last) // 2
            if matrix[mid // cols][mid % cols] == target:
                return True
            if matrix[mid // cols][mid % cols] > target:
                last = mid - 1
            if matrix[mid // cols][mid % cols] < target:
                first = mid + 1
        
        return False