'''
// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        if m == 0: return False

        l, r = 0, m * n - 1
        while l <= r:
            mid = (l + r) // 2
            num = matrix[mid // n][mid % n]
            if target == num:
                return True
            if target < num:
                r = mid - 1
            else:
                l = mid + 1
        return False