# Time Complexity : O(log*n) + O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# We are doing binary search 2-times, One to find the list where the target will be in.
# and other binary search for determining whether target is in that list or not.


class Solution:
    def searchMatrix(self, matrix, target) -> bool:
        a = 0
        b = len(matrix) - 1
        while a <= b:
            mid = a + (b-a)//2
            if target > matrix[mid][-1]:
                a = mid + 1
            elif target < matrix[mid][0]:
                b = mid - 1
            else:
                break
        a = 0
        b = len(matrix[mid]) - 1
        while a <= b:
            mid1 = a + (b-a)//2
            if matrix[mid][mid1] == target:
                return True
            elif matrix[mid][mid1] > target:
                b = mid1 - 1
            else:
                a = mid1 + 1
        return False


check = Solution()
print(check.searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))

