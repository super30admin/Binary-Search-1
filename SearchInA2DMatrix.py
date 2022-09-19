class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # This is a solution using binary search 
        
        # The brute force approach takes O(n^2) time complexity
        
        left = 0
        right = (len(matrix) * len(matrix[0])) - 1
        
        while left <= right:
            mid = (left + right)//2
            
            row = mid // len(matrix[0])
            col = mid % len(matrix[0])
            
            if target < matrix[row][col]:
                right = mid - 1
            elif target > matrix[row][col]:
                left = mid + 1
            elif target == matrix[row][col]:
                return True
        return False
    
    # Time complexity: O(log(n))
    # Space complexity: O(1)