"""
-Time Complexity : O(log(MN))
-Space Complexity : O(1)
-Did this code successfully run on Leetcode : Yes

-Any problem you faced while coding this : No
Previously I had solved the question with TC= O(M + logN) which was intuitve to
me to begin with.

-Your code here along with comments explaining your approach in three sentences only
Just visualize the 2D matrix as 1D matrix and map the 1D index to 2D row and col.
Since we know last element of row i < first element of row i+1, so this approach
can be used. 
2D indicies 
row = 1Dindex // (number of columns)
col = 1Dindex % (number of columns)
Where 1Dindex is in [0, m*n)
"""

def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    m = len(matrix)
    n = len(matrix[0])
    low = 0
    high = m*n - 1
    while low <= high:
        mid = low + (high-low)//2
        row = mid // n
        col = mid % n
        if target == matrix[row][col]:
            return True
        elif target <  matrix[row][col]:
            high = mid - 1
        else:
            low = mid + 1
    return False