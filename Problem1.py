# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# we are treating this matrix as a 1D array and then performing our standard binary search

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
            if not matrix:
                return False
            m =  len(matrix)
            n = len(matrix[0])
            left = 0
            right = m * n - 1

            while left <= right:
                piviot_index = (left + right) // 2
                piviot_value = matrix[piviot_index // n][piviot_index % n]

                if piviot_value == target:
                    return True
                elif piviot_value > target:
                    right = piviot_index - 1
                else:
                    left = piviot_index + 1

            return False