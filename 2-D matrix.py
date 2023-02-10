// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No



class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #rows
        m = len(matrix)
        #columns
        n = len(matrix[0])
        low = 0
        high = (m*n) - 1
        print(high)
        while(low<=high):
            print(low,high)
            mid = low+(high-low)//2
            # print(mid)
            r = mid//n
            c = mid%n
            if matrix[r][c]==target:
                return True
            elif matrix[r][c]<target:
                low = mid+1
            else:
                high = mid-1
        return False