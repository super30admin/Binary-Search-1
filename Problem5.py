class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lo, hi = 0, len(matrix) - 1
        while lo <= hi:
            midRow = (lo + hi) // 2
            row = matrix[midRow]
            if target < row[0]: hi = midRow - 1
            elif target > row[-1]: lo = midRow + 1
            else:
                l, h = 0, len(row) - 1
                while l <= h:
                    mid = (l + h) // 2
                    if row[mid] == target: return True
                    elif target > row[mid]: l = mid + 1
                    else: h = mid - 1
                return False
 
 #Time Complexity : O(logM) + O(logN)
 #Used binary search for sorting elements 
 # to check elements in each row low to high