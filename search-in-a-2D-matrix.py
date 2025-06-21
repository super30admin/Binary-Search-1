'''
Time complexity: O(log m) + O(log n ) which is equivalent to O(log m * n )
Space complexity: O(1)
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        top, bottom = 0, rows-1
        # narrow the search space to a row level
        while top<=bottom:
            row = top + (bottom-top)//2
            if target > matrix[row][-1]:
                top = row +1
            elif target < matrix[row][0]:
                bottom = row -1 
            else:
                break
        
        if not top<=bottom:
            return False
        
        left, right = 0, cols-1
        # search for the element in the row obtained previously 
        while left<=right:
            mid = left + (right-left)//2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                right = mid -1 
            else:
                left = mid +1 
            
        return False