# Time Complexity: O(log(m * n))
# m * n is total number of elements, Binary search takes log(m * n) times to find the element.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# I assumed 2D array as a flatend 1D sorted array and used binary search to find the target
# m is number of rows and n is number of columns
# low is starting index and high is the ending index of 1D array and then binary search

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]: # checking if matrix itself is empty, and checks if first row is empty
            return False
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False