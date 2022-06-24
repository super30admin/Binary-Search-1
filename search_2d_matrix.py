#time complexity:O(log m*n)
# space complexity: O(1)
# Approach:
# we imagine the 2d array as 1d array. 
# the row index in 2d array can be retrieved by using 1-d array index//total colmns
# the col index in 2d array can be retrieved by using 1-d array index % total colmns
# hence we can do the normal binary search and map it to the corresponding row-col index

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_len =len(matrix)
        col_len = len(matrix[0])
        left = 0
        right = (row_len*col_len) - 1
        while(left<=right):
            mid = left + (right - left)//2
            row = mid//col_len
            col = mid % col_len
            if matrix[row][col]== target:
                return True
            elif matrix[row][col]>target:
                right = mid-1
            else:
                left = mid+1
        return False
            
        
        