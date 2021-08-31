# Time Complexity : O(n)
# Space Complexity : O(1)
# Is this problem on the leetcode: Yes
# Approach to solve this problem:

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:                          # if its not a matrix
            return False
        # Finding our row
        row = 0
        
        for r in range(len(matrix)):                             
            if target == matrix[r][0] or target == matrix[r][-1]:   # Checking left and right value as an answer
                return True
            elif target > matrix[r][0] and target < matrix[r][-1]:  # If our target value is greater than the matrix
                row = r
                break
                
        # Look for the element in the row
        l, r = 0, len(matrix[row]) - 1                    # Initializing left and right(l,r)
        while l <= r:
            mid = l + (r - l)// 2                         # Calculating mid
            if target == matrix[row][mid]:                # If target is in mid
                return True
            elif target > matrix[row][mid]:               # If target is bigger than mid
                l = mid + 1
            else:                                         # If target is less than mid
                r = mid - 1
                
        return False
            
        
        