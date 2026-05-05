"""
Find the row of the target element first
and then using that row do binary search to find the target
Time Complexity : O(log mn )
Space Complexity : O(1)
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        top = 0
        bottom = len(matrix) - 1


        while top <= bottom:
            mid = (top + bottom) // 2 

            if target > matrix[mid][-1]:
                top = mid + 1
            elif target < matrix[mid][0]:
                bottom = mid - 1
            else:
                break
        

        row = (top + bottom) // 2

        l, r = 0, len(matrix[0]) - 1

        while l <= r:

            mid = (l + r) // 2

            if target > matrix[row][mid]:
                l = mid + 1
            elif target < matrix[row][mid]:
                r = mid - 1
            else:
                return True
        
        return False


        