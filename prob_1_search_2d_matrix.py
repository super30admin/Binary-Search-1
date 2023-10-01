class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Time Complexity: O(log(m x n))
        Space Complexity: O(1)

        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this:
        Initally I thought of only checking the first element of each row.
        I didn't think about checking the last element as well. That caused some trouble in
        dealing with this problem

        Your code here along with comments explaining your approach:
        The approach: 
            -> Perform Binary Search on the rows 
            -> Check the first and last element of each row and see if the target lies in
            between.
            -> If it lies in between break out of the loop and perform binary search just on
            that row
            -> If mid == target return True 
            -> If nothing then return False
        """
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = len(matrix) -1 
        row = 0
        while (low <= high):
            mid = int(low + (high - low)/2)
            if matrix[mid][0] <= target  and matrix[mid][n-1] >= target:
                row = mid                
                break
            elif matrix[mid][0] > target:
                high = mid - 1
            else:
                low = mid + 1

        low = 0 
        high = n - 1
        while (low <= high):
            mid = int(low + (high - low)/2)
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                high = mid - 1
            else: 
                low = mid + 1
        return False a