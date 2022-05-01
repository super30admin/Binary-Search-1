# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix, target):
        ROWS = len(matrix)
        COLS = len(matrix[0])
        
        low = 0
        high = ROWS * COLS - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            #Calculating index position of mid element
            r = mid // COLS
            c = mid % COLS
            
            # Target found
            if matrix[r][c] == target:
                return True
            
            # Target belongs to left sub-array
            elif matrix[r][c] > target:
                high = mid - 1
            
            # Target belongs to right sub-array
            else:
                low = mid + 1
            
        return False

solution = Solution()
print(f"OUTPUT >> {solution.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3)}")