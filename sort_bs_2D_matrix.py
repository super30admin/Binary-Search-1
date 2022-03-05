'''
// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Little difficult to arrive the logic


// Your code here along with comments explaining your approach

Consider m x n 2D Array as a normal Array
    - to get row = idx//n   where idx is : =location of element if a 2D array is converted to 1D array 
    - to get col = idx % n
    Eg: [[2,3,4]
         [5,6,7]]
         
         m=2, n=3
         
         - suppose you want to access elem 7, if you consider it as 1D array its index is 5
         - In 2D array row =5//3 -> 1
         -             col= 5%3 -> 2
         - So you can access 6 by matrix[1][2]
    
    - To get value of mid element instead arr[mid] ( as typically in Binary Search ) arr[pivot//n][pivot%n]
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        # binary search
        left, right = 0, m * n - 1
        while left <= right:
                pivot_idx = (left + right) // 2
                pivot_element = matrix[pivot_idx // n][pivot_idx % n]
                if target == pivot_element:
                    return True
                else:
                    if target < pivot_element:
                        right = pivot_idx - 1
                    else:
                        left = pivot_idx + 1
        return False
