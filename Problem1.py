# // Time Complexity :O(LogN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :No
# https://leetcode.com/problems/search-a-2d-matrix/description/
# In this sol we are trying to avoid either one row or one col at one time 


class Solution:
    def searchMatrix(self, m: List[List[int]], target: int) -> bool:
        r,c= 0,len(m[0])-1
        while( r<len(m) and c>-1):
            if m[r][c]==target:
                return True
            elif m[r][c] > target:
                c-=1
            else:
                r+=1
        return False
