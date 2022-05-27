'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Run on Leetcode: YES
Problems: Handling row selection and then applying binary search on that particular row
'''
class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        low = 0
        high = len(matrix) - 1
        col = len(matrix[0]) - 1
        while low <= high:
            mid = low + (high - low)//2
            if matrix[mid][0] <= target and target <= matrix[mid][col]:
                low = 0
                high = col
                while low <= high:
                    row_mid = low + (high - low)//2
                    if matrix[mid][row_mid] == target:
                        return True
                    elif matrix[mid][row_mid] < target:
                        low = row_mid + 1
                    else:
                        high = row_mid - 1
                return False
            elif target < matrix[mid][0]:
                high = mid - 1
            else:
                low = mid + 1
        return False