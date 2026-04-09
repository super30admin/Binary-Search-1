# // Time Complexity : O(log m + log n) = O(log m*n) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

class Solution(object):
    def binary_search_m(self,m,n,arr,target):
        start=0
        end=m-1
        while start <=end:
            mid = start + (end-start)//2
            if target == arr[mid][n-1]:
                return mid
            elif target < arr[mid][n-1]:
                end=mid-1
            else:
                start=mid+1
        
        return start

    def binary_search_n(self,m,n,arr,target):
        start=0
        end=n-1
        while start <=end:
            mid = start + (end-start)//2
            if target == arr[mid]:
                return True
            elif target < arr[mid]:
                end=mid-1
            else:
                start=mid+1
        return False

    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m=len(matrix)
        n=len(matrix[0])
        m_ind = self.binary_search_m(m,n,matrix,target)

        if m_ind == m: return False 
        n_ind = self.binary_search_n(m,n,matrix[m_ind],target)

        return n_ind
        