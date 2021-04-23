#binary search a 2D matrix
''' Time complexity : O(log mn)
Space Complexity: O(1)

Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No'''

# approach - Consider the matrix to be a linear sorted array and do binary search. to find middle
#element index r = mid//col_num and c = mid%col_num

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # get row and col numbers
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0]) 
        # binary search
        low, high = 0, (m * n) -1
        while low <= high:
                mid = (low + high) // 2
                r = mid//n
                c = mid%n
                if matrix[r][c] == target:
                    return True
                elif target > matrix[r][c]:
                        low = mid + 1
                else:
                    high = mid-1
        return False
        
        
