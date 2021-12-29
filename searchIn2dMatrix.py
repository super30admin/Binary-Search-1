# Time Complexity :
# log(M) + log(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # Using binary search to find a row in a matrix in which the element is present
        def getRow(matrix, target):
            
            row = None
            low = 0
            high = len(matrix) - 1
        
            while low<=high:

                mid = (low+high)//2

                if matrix[mid][0] == target:
                    row = mid
                    return row
                elif matrix[mid][0] < target:
                    if (mid==len(matrix) - 1) or (matrix[mid+1][0] > target):
                        row = mid
                        return row
                    else:
                        low = mid + 1
                else:
                    high = mid - 1
                    
            return -1
        
        row = getRow(matrix, target)
        
        if row == -1:
            return False
        else:
            searchArr = matrix[row]
        
        low1 = 0
        high1 = len(matrix[0]) - 1
        
        # Using second binary search to find the element in the srow
        while low1<=high1:
            
            mid = (low1+high1)//2
            
            if searchArr[mid] == target:
                return True
            elif searchArr[mid] < target:
                low1 = mid+1
            else:
                high1 = mid-1
                
        return False