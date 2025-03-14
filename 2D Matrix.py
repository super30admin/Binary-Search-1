"""
This solution performs a two-step binary search to efficiently locate the target in a sorted 2D matrix. 
First, it uses binary search on the row level to find the potential row where the target could exist. 
Then, it performs a second binary search within that row to determine whether the target is present, 
achieving an overall time complexity of O(log R + log C).
Space Complexity: O(1)
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])

        top, bot = 0, ROWS - 1

        while top <= bot:
            row = top + (bot - top)//2
            if target > matrix[row][-1]:
                top = row + 1
            elif target < matrix[row][0]:
                bot = row - 1
            else:
                break

        if not (top <= bot):
            return False
        row = (top + bot) // 2
        result = self.binarySearch(matrix[row], target)

        return result

    def binarySearch(self, nums, target):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high-low)//2

            if target == nums[mid]:
                return True
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return False
