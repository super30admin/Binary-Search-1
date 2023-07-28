#Time Complexity=O(Log(m*n))
#Space Complexity=O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        #First check whether the given martix length is >0 or not if it is zero return false
        if m==0:
            return False
        n=len(matrix[0])
        low=0
        high=m*n-1
        
        #perform binary search untill the left point crosses the right pointer 
        while low<=high:
        # calculate the index of the middle element is the target, return its index
            middle=low+(high-low)//2  #prevent integer overflow
            row=middle//n
            column=middle%n
            if target==matrix[row][column]:
                return True
        # check if the target is on the left side of the matrix
            elif target<matrix[row][column]:
                high=middle-1 #update the right pointer to find the target
            else:
                low=middle+1 #otherwise update the left pointer to find the target
        # If the target is not found in the array, return -1    
        return False

        