# Time Complexity : O(log mn) m ir row of matrix and n is column of matrix
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Had to refer to suggestion in order to come to this approach


# Your code here along with comments explaining your approach : - We consider the elements as flat array and consider them similar as elements for bianry search
# but in this case just in order to find the mid in matrix we do mid//n for row and mid%n and column in order to exactly locate the element and then we keep this process similar to binary search


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        first = 0 
        n = len(matrix)
        m = len(matrix[0])
        last = (n*m)-1
       
        while first <= last:
            mid = (first+last)//2
            if matrix[mid//(m)][mid%(m)] == target:
                return True
            elif matrix[mid//(m)][mid%(m)] > target:
                last = mid -1
            elif matrix[mid//(m)][mid%(m)] < target:
                first = mid +1
        return False
        
        
    