// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix==None or len(matrix)==0):
            return False
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1
        while(low<=high):
            mid=(low+high)//2
            r=mid//n
            c=mid%n
            if(matrix[r][c]==target):
                return True
            elif(matrix[r][c]>target):
                high=mid-1
            else:
                low=mid+1
        return False
