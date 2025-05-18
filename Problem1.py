"""

Time Complexity: O(log(m*n))

Space Complexity: O(1)

Approach: 
We can use a virtual 1D array to search the matrix. 
The virtual array is a 1D array that is used to represent the matrix. 
Each element in the virtual array is the index of the element in the matrix. 
For example, if we have a matrix like this:

1 2 3
4 5 6
7 8 9

The virtual array would be:

0 1 2 3 4 5 6 7 8 9

We can use the virtual array to search for a target element in the matrix. 
We start by initializing two variables, low and high, to the first and last indices of the virtual array, respectively. 
We then repeatedly divide the virtual array in half until we find the target element or until the low and high indices meet. 
If the target element is found, we return True. 
If the target element is not found, we return False. 
    
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # Virutal 1D Array using which the search can be done

        ROWS, COLS = len(matrix), len(matrix[0])

        def place_row(virtualIndex):
            return virtualIndex // COLS

        def place_columns(virtualIndex):
            return virtualIndex % COLS

        low = 0
        high = ROWS * COLS - 1

        while low <= high:

            mid = low + (high - low) // 2

            r = place_row(mid)
            c = place_columns(mid)

            element = matrix[r][c]

            if element == target:
                return True

            if element < target:
                low = mid + 1
            else:
                high = mid - 1

        return False
