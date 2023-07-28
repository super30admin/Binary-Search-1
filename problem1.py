# Time Complexity : O(log(m * n)) where m is the number of rows and n is the number of columns, log because each comparison reduces the search space by half
# Space Complexity : O(1) as no extra space was used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried brute force first by traversing the entire matrix but that was O(m * n) time complexity, used binary search and Raj's sir approach. 


# Your code here along with comments explaining your approach in three sentences only 
# Search 2D Matrix
# I used binary search to find the target in the 2D matrix. I imagine the 2D array as 1D array and find the mid and then 
# I find the row and column of the mid element using mathematical operations (mid // n and mid % n) and then apply binary search on the row and column

from typing import List

def searchMatrix(matrix: List[List[int]], target: int) -> bool:
        
        if not matrix or len(matrix) == 0:
            return False
        

        # Find the dimensions first
        m = len(matrix)
        n = len(matrix[0]) # as the rows are of equal length

        # Set high and low for binary search
        low = 0
        high = (m * n) - 1  


        while low <= high:
              
              # Calcualte mid 
              mid = low + (high - low) // 2 # To prevent integer over flow 

              # Calculate row and col co-ords according to the mid
              row = mid // n
              col = mid % n

              # Apply binary search 

              # if mid is the target, we return false
              if target == matrix[row][col]:
                    return True
              
              # else if targer is greater, that means we need to move right
              elif target > matrix[row][col]:
                    low = mid + 1

                # Else target is in the left so we move left
              else:
                    high = mid - 1



        # If we exit the loop that means low is greater than high, i.e we did not find the target, return false

        return False 
                




