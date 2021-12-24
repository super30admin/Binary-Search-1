"""

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

"""

# Time Complexity : O(log m*n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # In this function, first get the size of matrix from m and n as per constraints in the question
        m = len(matrix)         #rows
        print(m)
        n = len(matrix[0])      #columns
        print(n)

        if m == 0 or n > 100:   # As per the constraints in the question
            return False

        l, r = 0 , (m * n) - 1      # Converts matrix into a sorted array in the range of [l,r]
        
        while l < r:
            
            # finding the mid index for binary search
            mid = (l + r) // 2  

            # finding the mid element (to know what element to compare the target with)
            mid_element = matrix[mid // n][mid % n] 

            if target <= 10000:                 # as per constraint
                if mid_element > target:
                    r = mid - 1
                elif mid_element < target:
                    l = mid + 1
                elif mid_element == target:
                    return True
            else:
                print("Target value too large")
                return False

        return False

s = Solution()
x = 32
mat = [[0, 6, 8, 9, 11],
        [20, 22, 28, 29, 31]]

result = s.searchMatrix(mat, x)
if result == True:
    print("Element is present in the matrix")
else: 
    print ("Element is not present in matrix")