# Time Complexity : O(log m*n)
# Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
#1. We use binary search to find the target in a 2D matrix for this we flatten the 2d matrix to an array.
#2. We treat the 2D matrix as a 1D array by calculating the row and column indices from the mid index.
#we use r and c by dividing mid by n (number of columns) and taking the modulus with n respectively.
#3. If the target is found, we return True; otherwise, we adjust the search range based on the comparison with the mid element.

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        #get the number of rows and columns in the matrix
        m=len(matrix)
        n=len(matrix[0])
        #low will be the starting index and high will be the last index of the flattened matrix
        low=0
        high=m*n-1
        #binary search to find the target in the flattened matrix
        while low<=high:
            mid=low+(high-low)/2
            #calculate the row and column indices from the mid index
            #if you divide mid by number of columns n, you get the row index r
            #and if you take mid modulo n, you get the column index c
            r=mid/n
            c=mid%n
            #if the target is found at the mid position, return True
            if matrix[r][c]==target:
                return True
            #if the target is less than the mid element, adjust the high pointer to mid-1 and search in the left half
            # if the target is greater than the mid element, adjust the low pointer to mid+1 and search in the right half
            if matrix[r][c]<target:
                low=mid+1
            else:
                high=mid-1
        #if the target is not found, return False
        return False