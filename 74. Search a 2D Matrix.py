# Time Complexity : O(log mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach in three sentences only
    # Thought of it as 1D array but did not convert it as complexities would increase
    # To access the element at mid we'll get the col by dividing by total elements and the row by the %
    # Perform normal binary search then


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        m = len(matrix)
        n = len(matrix[0])
        high = (m*n) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (target == matrix[mid // n][mid % n]):
                return True
            elif (target < matrix[mid // n][mid % n]):
                high = mid - 1
            else:
                low = mid + 1
        return False