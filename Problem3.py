# Time Complexity  : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode? : Yes
# Any problems you faced while coding this?   : No, I was able to code the solution easily.

# Your code here along with comments explaining your approach in three sentences only:
# I treated the 2D matrix as a 1D sorted array and applied binary search across the virtual 1D range.
# At each step, I converted the 1D index back into 2D coordinates using row = index // columns and col = index % columns.
# I compared the matrix value at that position with the target, adjusting the search range accordingly.



class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        rows = len(matrix)
        columns = len(matrix[0])
        low = 0
        high = rows*columns - 1

        while low<high:
            mid = low+(high-low)//2
            mid_element = matrix[mid//columns][mid%columns]

            if mid_element == target:
                return True
            elif target < mid_element:
                high = mid - 1
            else:
                low = mid + 1
        
        if matrix[low//columns][low%columns] == target:
            return True
        else:
            return False    
        