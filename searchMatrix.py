//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :NO
// Any problem you faced while coding this : Time Limit Exceeded




class Solution(object):

    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m=len(matrix)
        if m==0:
            return False
        n=len(matrix[0])
        low,high = 0, m*n -1
        while low <= high:
            mid =( low + high ) //2
            pivot_element = matrix[mid//n][mid%n] 
            if(target==pivot_element):
                return True
            else:
                if(target < pivot_element):
                    high=pivot_element -1
                else:
                    low = pivot_element +1
        return False