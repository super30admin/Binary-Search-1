"""
Runtime Complexity:
O(log m*n) where m is the number of rows and n is the number of columns. We perform a binary search on this matrix of m rows and n columns. Binary search for 
'n' elements take O(log n), but in this case we are given a matrix.
Space Complexity:
O(1) -  no extra space is used to compute the solution.

Yes, the code worked on leetcode.

- to find the particular row in which the element is located, we perform mid//n, Which gives us the row with range in which the target element might reside. 
We find the column by taking mod of the mid, which gives us the column. Now we check, whether the target is greater than mid or lesser and move left or right halve respectively according
to the target element respectively or return False if not found.
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) ==0:
            return False
        m = len(matrix)     #number of rows
        n = len(matrix[0])  #number of columns
        low = 0
        high = m * n -1
        
        
        while low<=high:
            mid = low+(high-low)//2
            row= mid//n
            column = mid%n
            
            if matrix[row][column]==target:
                return True
            if matrix[row][column]<target:
                low = mid+1
                
            else:
                high =mid-1
        return False
                
        
        
