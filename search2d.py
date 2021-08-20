# // Time Complexity :O(n^2)
# // Space Complexity :O(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :not the optimal solution


# // Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1
        while True:
            if low>high:
                return
            
            mid=(low+high)//2
            r=mid//n
            c=mid%n
            print(matrix[r][c])
            if(target==matrix[r][c]):
                return True
            if(target<=matrix[r][c]):
                # print("l",matrix[r][c])
                high=mid-1
            else:
                # print("r",matrix[r][c])
                low=mid+1
        return -1


        