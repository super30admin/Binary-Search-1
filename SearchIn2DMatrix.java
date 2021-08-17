/*74. Search a 2D Matrix
Running Time Complexity: O(log n)
Space Complexity: Constant
Successfully Run and Compiled on leetcode
*/
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        while high>=low:
            mid = low+(high-low)//2
            r = mid // n
            c = mid %n
            if matrix[r][c]==target: 
                return True
            elif matrix[r][c]>target:
                high = mid-1
            else:
                low = mid+1
        return False
            
            