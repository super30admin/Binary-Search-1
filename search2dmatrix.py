# Time Complexity :  O(logm)+O(logn)
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #initialize left and right to start and end index of the matrix respectively
        left = 0
        rows = len(matrix)
        cols = len(matrix[0])
        right = rows*cols-1
        
        
        while(right>=left):
            #mid_index if considered as 1D array
            mid_index = left + (right-left)//2 #to avoid overflow
            
            #to find ele at mid_index in 2D array
            i = mid_index//cols
            j = mid_index%cols

            mid_ele = matrix[i][j]
            
            if target == mid_ele:
                return True
            #if target is greater than mid_ele then reduce the search space by half and shift left to mid+1
            if target>mid_ele:
                left = mid_index+1
            #if target is lesser than mid_ele then reduce the search space by half and shift right to mid-1
            else:
                right = mid_index-1
        
        return False
                
             