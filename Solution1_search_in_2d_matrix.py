// Time Complexity : O(log(m)) +O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

'''
 1. Binary search for each row to find if the target element is with 
      the range by usinf row index and column start and end values
 2. Use a row_col pointer to see if the value is in range or not, if not 
    we return False 
 2. After finding which row index the element is in,
    Do a binary search of elements for the particular list.
	keeping track of minimum element at a given time
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row,col= len(matrix),len(matrix[0])
        
        start=0
        end=row-1
        row_col = -1
        
        while (start <= end) and (row_col ==-1):
            
            mid= start+ (end-start)//2
            if matrix[mid][0] <= target and target <= matrix[mid][col-1]:
                row_col=mid
            else:
                if target>matrix[mid][0]:
                    start=mid+1
                else:
                    end=mid-1
               
        if row_col == -1:
            return False
        
        low=0
        high=col-1
        
        while low<=high:
            mid=low+(high-low)//2
            
            if target == matrix[row_col][mid]:
                return True
            else:
                if target > matrix[row_col][mid]:
                    low=mid+1
                else:
                    high=mid-1
        return False
        