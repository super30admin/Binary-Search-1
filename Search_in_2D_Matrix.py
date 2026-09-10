// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have used Binary Search for finding the target in 2D matrix by imagining it as a flattened array so the low is 0 and high = m*n-1
#After finding mid we can calculate the row and column index and then check if it is equal to target if not we move the low/high pointer


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n - 1
        while low <= high:
            mid = low + (high - low) // 2
            row = mid // n
            column = mid % n
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False

#Time - O(logmn) = O(logm) + (logn)
#Space - O(1)
