from typing import List
# Time Complexity : O(logn) because first we divide the matrix in halves to determine where the target lies and then again
# to search between the row we do a binary search so techincally O(2logn) which is equivalent to O(logn)
# Space Complexity : O(1) no extra space used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l = 0
        h = len(matrix)-1
        while (l <= h):
            mid = l + (h - l) // 2
            if target < matrix[mid][0]:
                h = mid - 1
            elif target > matrix[mid][-1]:
                l = mid + 1
            else:
                return self.binarySearch(matrix[mid], target)

        return False

    def binarySearch(self, arr, target):
        l = 0
        h = len(arr) - 1
        while (l <= h):
            m = l + (h - l) // 2
            if arr[m] == target:
                return True
            elif target > arr[m]:
                l = m + 1
            else:
                h = m - 1

        return False


solution = Solution()
print(solution.searchMatrix([[1]], 2))
