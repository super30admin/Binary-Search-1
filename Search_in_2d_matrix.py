'''The import statement from typing import List indicates that the code is 
using type hints, specifically the List type, which allows us to specify 
the type of elements in the list.

The searchMatrix function is designed to search for a target element in 
the given matrix, which is a 2D list of integers. It uses a modified 
binary search algorithm to achieve O(log m*n) time complexity.

The function first checks if the matrix is empty or None, returning False 
if so. Then it initializes pointers low and high to perform binary search 
on the flattened 2D matrix. The function returns True if the target is 
found, and False otherwise.
'''

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False

