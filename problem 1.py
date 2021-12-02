# // Time Complexity :O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low=0
        m=len(matrix)
        n=len(matrix[0])
        high=(m*n)-1
        # standard binary search check approach
        while(low<=high):
            mid=(low+high)//2
            # row and column hashing fucntion 
            r=mid//n
            c=mid%n
            # if element found at target return true 
            if matrix[r][c]==target:
                return True
                # target less than element move left 
            elif target< matrix[r][c]:
                high=mid-1
            else:
                # target greater move right
                low=mid+1
            
        return False