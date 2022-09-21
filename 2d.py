##Time Complexity : O(log(m)+log(n)) = O(log(mn))
##Space Complexity : O(1)
##Did this code successfully run on Leetcode : Yes

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
        	return 0
        l, r = 0, len(matrix[0])-1

        while l < len(matrix) and r >= 0:
        	if matrix[l][r] == target:
        		return True 
        	elif matrix[l][r] < target:
        		l += 1
        	else:
        		r -= 1
        return False