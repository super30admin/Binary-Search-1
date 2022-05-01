#many methods
#method-1
#imagine the 2d array as a 1-d array and do binary search
#method-2
#do binary search on columns-when you find bid -check if target lies in that range,if yes do binary search on that row
#method-3
#for each row check if target lies in the range,if yes do binary search on that row

'''O(log(mn)) Time complexity
   O(1) space complexity'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low=0
        high=len(matrix)*len(matrix[0])-1
        while low<=high:
            mid=low+(high-low)//2
            #find row and column
            #why division by this number--
            r=mid//len(matrix[0])
            c=mid%len(matrix[0])
            if matrix[r][c]==target:
                return True
            else:
                if matrix[r][c]>target:
                    high=mid-1
                else:
                    low=mid+1
        return False
        