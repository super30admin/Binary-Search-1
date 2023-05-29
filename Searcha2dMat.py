# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the row in which target is present then do the binary search for the same row .

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in matrix:
            print(i)
            if ((i[0]<=target) and (i[-1]>=target)):
                break
        s=i
        n=len(s)-1
        l=0
        while(l<=n):
            m=(n + l) // 2
            if s[m] < target:
                l=m+1
            elif s[m] > target:
                n = m-1
            else:
                return True
        return False