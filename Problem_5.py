# Time Complexity : O(log mn) since we basically made flattened array of size m*n and applied binary search to it
# Space Complexity : O(mn) for tghe matrix. No auxiliary space required so constant space in that regards (other than for variables like low, high, m,n which is negligibe as its also O(1))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        m = len(matrix) # Finding m i.e no. of rows
        n = len(matrix[0]) # Finding n i.e no of colunmns
        
        low = 0 # Setting low to 0 and high to m*n - 1 to start binary search
        high = (m*n) - 1 # We assume the 2D matrix as one large array of size m*n and perform binary search on it
        
        while low<=high:
            mid = low + (high-low)//2 # Use low + (high-low)//2 instead of (low+high)//2 to avoid overflow if low and high are very large numbers
            # We are assuming the array is of size m*n for m arrays of size n
            # So row of an element can be assigned as index in 1D array/n and column as index in 1D array%n i.e dividing index (in the flattened 1D ) with column size will give us row index and modulo will give column index
            # Eg: matrix=[[1,2,3],[4,5,6]] can be changed to [1,2,3,4,5,6]
            # To obtain index of element 6 which is at index 5 in the flattened array, row = 5/3 = 1 and column 5%3 = 2. So 5 is at matrix[1][2]  
            
            if target == matrix[mid//n][mid%n]:
                return True
            
            elif target < matrix[mid//n][mid%n]:
                high = mid - 1
            
            else:
                low = mid +  1
        return False