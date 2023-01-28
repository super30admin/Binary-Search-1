
# All test cases in leetcode passed.
# Here we treat the matrix as 1 array and apply binary search to search the target element. 
# To get index of mid in [row][col] format we divide and mod, mid with columns respectively.
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        
        rows = len(matrix)
        cols = len(matrix[0])

        l = 0
        h = (rows*cols)-1

        while l<=h:
            mid = (l+h)//2

            r = mid//cols
            c = mid%cols

            if matrix[r][c]==target:
                return True
            elif matrix[r][c]<target:
                l = mid+1
            else:
                h = mid-1
        
        return False


        