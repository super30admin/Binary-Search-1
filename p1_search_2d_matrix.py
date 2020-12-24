# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES 
# Any problem you faced while coding this : starting it few didn't pass but later added the edge case
#Can I cut down few things to make more clear of my solution

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Check for matrix and also matrix[0] element if not return false
        if not matrix or not matrix[0]:  
            return False
    
        #check for value in particular row

        row = 0
        for r in range(len(matrix)):
            if target == matrix[r][0] or target == matrix[r][-1]:
                return True
            elif target > matrix[r][0] and target < matrix[r][-1]:
                row = r
                break
        
        #perform a binary search for efficient solution and get the required result
        left, right = 0, len(matrix[row]) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == matrix[row][mid]:
                return True
            elif target > matrix[row][mid]:
                left = mid + 1
            else:
                right = mid - 1
                
        return False