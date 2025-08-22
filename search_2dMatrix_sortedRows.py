'''
Treat it as a flattened array and Then Binary search. 
Flattened idx --> matrix index:
    - How many rows? Controlled by column length
    - row_idx = idx // col
    - col_idx = idx % col
# Time Complexity : 
    O(log n) - Binary search
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)  
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - No
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = rows*cols -1

        while low<=high:
            mid = low + (high-low)//2
            r, c = mid//cols, mid%cols
            if matrix[r][c] ==target:
                return True
            if matrix[r][c]>target: # lies in left partition
                high = mid -1
            else: # lies in right partition
                low = mid + 1 
        return False

        