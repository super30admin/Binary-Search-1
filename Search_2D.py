#Time Compelxity : O(logmn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows,cols = len(matrix),len(matrix[0])
        start,end = 0,rows*cols-1
        while start <= end:
            mid = (start+end)//2
            mid_ele = matrix[mid//cols][mid%cols]
            if target == mid_ele:
                return True
            if target < mid_ele:
                end = mid-1
            else:
                start = mid+1
        return False
        
