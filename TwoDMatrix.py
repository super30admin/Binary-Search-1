# // Time Complexity : o(log(n))
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes


class Solution:
    def searchMatrix(self, matrix, target: int) -> bool:
        print(matrix)
        if not matrix or target is None:
            return False

        rows, cols = len(matrix), len(matrix[0])
        low, high = 0, rows * cols - 1

        while low <= high:
            mid = int((low + high) / 2)
            # Calculate the mid of the 2D array in every loop
            print(matrix[int(mid / cols)][int(mid % cols)])
            num = matrix[int(mid / cols)][int(mid % cols)]

            if num == target:
                return True
            elif num < target:
                low = mid + 1
            else:
                high = mid - 1

        return False


as1 = Solution()
print(as1.searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))
