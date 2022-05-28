#// Time Complexity : O(log n)
#// Space Complexity : O(1); as no extra space being used
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :no

#// Your code here along with comments explaining your approach
'''
Here the matrix is assumed to be 1d array, and the binary search is applied on it
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        if matrix is None or m == 0:
            return False
        while low <= high:
            mid = low + (high-low)//2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
                
        
        
