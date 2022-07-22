# Time Complexity :  O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : no

class Solution:
    
    def searchMatrix(self, matrix, target):  
        
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        M = len(matrix)         # m will be Row size
        N = len(matrix[0])      # N will be column size
        
        left = 0                 #make the left pointer point to 0
        right = (M * N) - 1      # the right pointer points to the last element of the matrix which is (M*N)-1
        
        while left <= right:
            mid = left + (right - left) // 2    #find the mid index
            mid_element = matrix[mid // N][mid % N]   #now find the mid value
            
            if mid_element < target:  #if mid element is lesser than the target, left will be mid index + 1
                left = mid + 1
            elif mid_element > target: #if mid element is greater than the target, right  will be mid index - 1
                right = mid - 1
            else:
                return True #else mid element will be equal to target
        
        return False #if nothing turns true, then the element is not present and return False