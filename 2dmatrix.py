class Solution:
    def searchMatrix(self, matrix, target):
        m=len(matrix)
        n=len(matrix[0])
        left,right=0,m*n-1
        while left<=right:
            pivot_idx=(left+right)//2
            pivot=matrix[pivot_idx//n][pivot_idx%n]
            if target==pivot:
                return True
            else:
                    if target < pivot:
                        right = pivot_idx - 1
                    else:
                        left = pivot_idx + 1
        return False