# Time Complexity : O(log(m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leet code : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
	# check if the input 2d array is empty or not and returns -1 if empty
        if matrix == None or len(matrix) == 0: 
            return -1

	# calculate no of row, col and low and high values for binary search
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n -1

	# perform binary search until the low is less than equal to high to search for the element else return False
        while low<=high:
	    # calculate mid element
            mid=low+(high - low)//2 # avoid integer overflow

	    # to find the indexes of and element in matrix (row and col) if matrix we use below operators 
            row = mid // n
            col = mid % n 

	    # if target is equal to the mid element return mid else change low and high values based on conditions
            if target == matrix[row][col]:
                return True
            elif target > matrix[row][col]:
                low = mid +1
            else:
                high = mid - 1
        return False