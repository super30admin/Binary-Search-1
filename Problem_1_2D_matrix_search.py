// Time Complexity : O(log(m*n)), since m*n is the entire matrix size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

      // Treat the 2D matrix as a single array, For searching an element in this single array, we need the row and col index of the mid element. 
      // mid_index divided by matrix column size gives the row idex of the middle element, modulo operation would give the column index
      // Once mid element is found, perform normal binary search. If target exists, return True, else return False

        m = len(matrix)
        n = len(matrix[0])

        t = m * n

        l, r = 0, t - 1

        while l <= r:
            m = (l+r) // 2

            i = m // n
            j = m % n

            mid = matrix[i][j]

            if mid == target:
                return True
            elif mid < target:
                l = m + 1
            else:
                r = m - 1
            
        return False
        
