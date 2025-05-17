# Time Complexity :O(log(m*n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach in three sentences only
# did binary search on 0 index column to find which row target might be in
# then did binary search on the row to check if target is there

class Solution:
    def binary_search(self, l, r, nums, target):
        while l<=r:
            k = (l+r)//2
            if nums[k]==target:
                return True
            elif nums[k]>target:
                r = k-1
            else:
                l = k+1
        return False
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if target>matrix[-1][-1] or target<matrix[0][0]:
            return False
        l=0
        r=len(matrix)-1
        while l<=r:
            k=(l+r)//2
            if matrix[k][0]==target:
                return True
            elif matrix[k][0]>target:
                r=k-1
            else:
                l=k+1
        if r<0:
            return False
        k=r
        nums = matrix[k]
        return self.binary_search(0,len(nums)-1,nums,target)
