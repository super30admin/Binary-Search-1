#Time Complexity :O(log mn)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix) #rows
        n=len(matrix[0]) #columns

        low=0
        high=m*n-1

        while(low<=high):
            
            mid=int(low+(high-low)/2)   #Index of mid element

            r=int(mid/n)
            c=int(mid%n)

            if matrix[r][c]==target:    #check if Mid element is target
                return True
            elif target<=matrix[r][c]:  #if Target element is less than or equal to mid element
                high=mid-1              
            else:
                low=mid+1
        return False
