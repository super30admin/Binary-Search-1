#Time Complexity: O(mn)
#Space complexity:O(1)
#Successfully ran on leetcode
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
	        for j in range(len(matrix[i])):
	            if matrix[i][j]==target:
	                return True
