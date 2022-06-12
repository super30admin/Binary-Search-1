'''
 Approaches:
 1) Use Linear search  - O(m*n) time to loop over the matrix
 2) Use binary search with idx manipulation:
 # for any index, idx//2 and idx%2 gives us exact row and column to find that idx
 so using l =0, h=m*n -1 , and idx = matrix[idx//n][idx%n] gives us perfect location for that
 index in the matrix. Hence making it equivalent to binary search( O(log n)) on a linear array
 no extra Space needed.
 '''
 class Solution:
     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
         m = len(matrix)
         if m == 0:
             return False
         n = len(matrix[0])

         l, h = 0, m * n - 1
         while l <= h:
             mid = (l + (h-l)//2)
             # for any index, idx//n and idx%n gives us exact row and column to find that idx
             e = matrix[mid // n][mid % n]

             if target == e:
                 return True
             elif target < e:
                 h = mid - 1
             else:
                 l = mid + 1