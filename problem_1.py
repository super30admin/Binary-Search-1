#time complexity - O(long r*c) where r is the number of elements in row and c is the number of elements in column
#space complexity - O(1) because it uses constant space
#Submit on leetcode - yes


class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        if not matrix[0]:
            return -1
        
        row = len(matrix)
        col = len(matrix[0])

        low = 0
        high = row*col -1

        while low <= high:
            mid = low +(high-low)//2
            row_val = mid//col
            col_val = mid%col
            mid_val = matrix[row_val][col_val]

            if mid_val == target:
                return True
            elif mid_val < target:
                low = mid+1
            else:
                high = mid-1
        
        return False
        
        
sol = Solution()
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 3
result = sol.searchMatrix(matrix, target)
print(result) 