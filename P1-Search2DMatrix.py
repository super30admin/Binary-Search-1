'''
  Approach(Solving as 1D Matrix): Since, in the matrix every row is sorted and last element of prev row is smaller than first element of
  next row, we can imagine the entire matrix as a sorted 1D array. Now, we can find the middle index by using lowest index and highest index
  and with middle index we can find the location(row index and column index) of that index in the 2d matrix by uisng ht formula, 
  row_index = element index / no of columns and same with column column_index = element index % no of coulms, and do the reagular binary seacrh 
  with the available midpoint location.
  
  TC -> O(log(m X n)) = logm + logn, where m -> total no of cols and n -> total no of rows
  SC -> O(1), since we are not using any actual 1D array and just imagining and computing around it

  Pseudo Code ->
  1. if matrix is empty, return 
  2. l = 0 & h = mXn-1
  3. Binary search using these l & h
    3.1 find mid, then r = mid/n & c = mid%n
    3.2 compare matrix[r][c] with target and continue regular BS
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        l = 0
        h = (m*n) - 1
        while(l<=h):
            mid = l + (h-l)//2
            r = mid//n
            c = mid%n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                h = mid -1
            else:
                l = mid +1

        return False
        
