#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

#consider matrix as list of list, basically this matrix is sorted array

class Solution:
    def searchMatrix(self, matrix, target) :
        low = 0
        cols = len(matrix[0])
        rows = len(matrix)
        high = rows * cols -1
        
        while low<=high:
            mid = low+(high-low)//2
            num = matrix[mid//cols][mid % cols]  #to access mid element we need to first check row then column
            if num == target:
                return True
            elif target > num:
                low = mid+1
            else:
                high = mid-1
        return False

mat = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = -3
q = Solution().searchMatrix(mat,target)
print(q)