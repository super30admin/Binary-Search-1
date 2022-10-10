#Time Complexity - O(log n)
#Space Complexity - O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        start = 0
        end = (len(matrix) * len(matrix[0])) - 1
        return self.binarySearch(start, end, matrix, target)
        
    def binarySearch(self, start, end, matrix, target):
        mid = (start + end) // 2
        row = mid // len(matrix[0])
        col = mid % len(matrix[0])
        if matrix[row][col] == target:
            return True
        if start > end:
            return False
        if target < matrix[row][col]:
            return self.binarySearch(start, mid - 1, matrix, target)
        else:
            return self.binarySearch(mid + 1, end, matrix, target)