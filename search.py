# // Time Complexity :O(log(mn))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we split the serach space to half and discard one half always. since the rows are sorted, we check if targte is lesser than the current val or not and update the end , 
# start boundaries value accordingly.
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        n = len(matrix[0])
        
        if(target > matrix[m-1][n-1] or target < matrix[0][0]):
            return False
        else:
        
            start=0
            end=m*n-1
            while(start <= end):
                mid=start + (end-start)/2
                row=mid / n
                col=mid % n
                if(target==matrix[row][col]):
                    return True
                elif(target<=matrix[row][col]):
                    end=mid-1
                else:
                    start=mid+1
                
        return False