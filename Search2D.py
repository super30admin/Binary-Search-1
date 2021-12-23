# Time Complexity : log(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
When you roll out the matrix row by row. We get a sorted array. Hence, we can perform BinarySearch in that
Sorted Array. All you have to do is handle calculating the correct rowIdx and correct colIdx.
'''


# Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m = len(matrix)
        n = len(matrix[0])
        
        left = 0
        right = (m * n) - 1
        
        while left <= right:
            pivot = left + (right - left) // 2
            rowIdx = pivot // n
            colIdx = pivot % n
            
            curr = matrix[rowIdx][colIdx]
            
            if target == curr:
                return True
            if target < curr:
                right = pivot - 1
            else:
                left = pivot + 1
            
        
        return False