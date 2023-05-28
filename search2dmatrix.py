# Time Complexity : O(log(m*n))
# Space Complexity :O(1)
# Leet Code: Yes
# changed implementation from O(m)+ O(n) to O(log(m*n))

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m * n - 1

        while l <= r:
            mid = l + (r-l)//2
            row = mid // n
            col = mid % n
            mid_val = matrix[row][col]
            if target == mid_val:
                return True
            elif target < mid_val:
                r = mid - 1
            else:
                l = mid + 1
        return False

# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         m = len(matrix)
#         n = len(matrix[0])
        
#         if target<matrix[0][0] or target>matrix[m-1][n-1]:
#             return False
#         i = 0
#         j = n-1
        
#         while j>=0 and i<=m-1:
#             if matrix[i][j]>target:
#                 j-=1
#             elif matrix[i][j]<target:
#                 i+=1
#             else:
#                 return True
#         return False