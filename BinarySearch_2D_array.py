from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        left =0
        right=m*n -1

        while left<=right:
            mid_point=(left+right)//2

            row=mid_point//n
            column=mid_point%n

            if target==matrix[row][column]:
                return True
            elif target< matrix[row][column]:
                right=mid_point-1

            else:
                left=mid_point+1

        return False
