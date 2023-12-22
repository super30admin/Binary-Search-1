# // Time Complexity : O log (M N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
# We need to perform Binanry search first to narrow down the row in which the target is present
# (we make use of the matrix constrints). Once we have the row we find target in that row by again
# performing a Binary Search.


class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def BinarySearch(arr, target):
            l = 0
            r = len(arr)
            while l <= r:
                mid = (l + r)//2

                if arr[mid] == target:
                    return True
                elif arr[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1

            return False
        M = len(matrix) - 1
        N = len(matrix[0])-1

        left = 0
        right = M

        while left <= right:
            mid = (left + right) // 2
            if matrix[mid][0] <= target <= matrix[mid][N]:
                return BinarySearch(matrix[mid], target)

            elif matrix[mid][N] < target:
                left = mid + 1

            else:
                right = mid - 1
