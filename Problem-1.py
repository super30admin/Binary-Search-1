# // Time Complexity : O(MxN)
# // Space Complexity : S(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Nope

# // Your code here along with comments explaining your approach


class Solution(object):
    def searchMatrix(self, matrix, target):
        flag = False
        for i in matrix:
            if target in i:
                flag =True
                return True
        if flag == False:
            return False
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """