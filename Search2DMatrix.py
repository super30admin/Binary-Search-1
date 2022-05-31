#74. Search a 2D Matrix

"""
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
We are imagining 2D array as 1D array. Not converting it, just using like 1D array to save time complexity

"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m = len(matrix) #no of rows
        if m == 0:
            return False

        n = len(matrix[0]) #no of columns

        low = 0
        high = m * n - 1

        #binary search
        while low <= high:
            mid = low + (high - low) // 2

            # get exact loaction in 2D array from assumed 1D array is given by // and % operation resp.
            #matrix[mid // n][mid % n] = middle element in 1D array
            if matrix[mid // n][mid % n] == target:
                return True

            elif target <= matrix[mid // n][mid % n]:
                high = mid - 1

            else:
                low = mid + 1
        return False
