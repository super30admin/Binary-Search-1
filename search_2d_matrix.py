# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)  # length of matrix which will be 3 fixed
        n = len(matrix[0])  # length of elements in matrix which will be 4 fixed
        l, h = 0, (m * n) - 1
        while l <= h:
            mid = l + (h - l) // 2  # preventing overflow
            r = mid // n  # calculate the row index
            c = mid % n  # calculate the column index
            if matrix[r][c] == target:  # checking if its target and returning true
                return True
            elif matrix[r][c] > target:  # if mid is greater than target, then target is on L.H.S
                h = mid - 1
            else:
                l = mid + 1  # if mid is Less than target, then target is on R.H.S
        return False  # if we exit the loop it means target not found so returning False