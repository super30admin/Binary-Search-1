"""
Time Complexity : O(log mn) since we are performing a binary search thinking the matrix is just an extended list
Space Complexity : O(1) since we are not declaring anything. We are just finding the mid element and comparing
                   till we find the target element
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix[0])
        n = len(matrix)
        l = 0
        u = m*n - 1

        while l <= u:
            mid = (l+u)//2
            num = matrix[mid//m][mid % m]
            if target == num:
                return True

            elif target < num:
                u = mid - 1

            else:
                l = mid + 1

        return False



