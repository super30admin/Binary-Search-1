'''
Time Complexity : O(log(m*n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach in three sentences only 

Approach: Flattening the matrix into an array. Find the target using binary search and calculate middle element each time by checking row and column in the flattened array.
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n) - 1
        while(low<=high):
            mid = low + (high - low)//2
            row = mid // n
            column = mid % n
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] > target:
                high = mid - 1
            else:
                low = mid + 1

        return False
