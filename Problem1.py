"""
TC: O(log(m*n)) {since we perform a binary search on an imaginary flattened 2D Matrix, the upper bound is m*n }
SC: O(1) {we dont use any extra space for this solution, we get the row, col indices using a flattening formula.}
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # O(log(m.n))
        # low, high = 0, len(matrix)-1

        # row = -1

        # while low <= high:
        #     mid = low + (high - low)//2

        #     if matrix[mid][0] <= target <= matrix[mid][-1]:
        #         row = mid
        #         break
        #     elif target < matrix[mid][0]:
        #         high = mid - 1
        #     else:
        #         low = mid + 1
        
        # low, high = 0, len(matrix[0])-1

        # while low <= high:
        #     mid = low + (high - low)//2  
        #     print(matrix[row][mid])
        #     if matrix[row][mid] == target:
        #         return True

        #     if matrix[row][mid] > target:
        #         high = mid - 1
        #     else:
        #         low = mid + 1

        # return False 
        n,m = len(matrix), len(matrix[0])
        low, high = 0, (n * m) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            #converting idx mid to contain in the matrix format
            mid_r = mid//m
            mid_c = mid%m
            # print(mid, mid_r, mid_c)

            if matrix[mid_r][mid_c] == target:
                return True
            
            if matrix[mid_r][mid_c] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False            