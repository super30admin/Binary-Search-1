# // Time Complexity : O(log(m*n)) where m = rows, n = columns
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, the concept was new to me, so faced some implementation issues


# // Your code here along with comments explaining your approach in three sentences only

'''
Here number of rows is dependent on columns. so using that the logic for finding the midpoint in row and column index was developed.

'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n - 1

        while low<=high:
            mid = low + (high - low)//2
            r = mid//n

            c = mid%n
            if matrix[r][c] == target:
                return True
            if matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
        
        
