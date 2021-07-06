# // Time Complexity : O(Log(N))
# // Space Complexity : O(1)
                # recursive stack space would be O(Log(N))
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this :
        # while working on edge case I was facing issue,
        #  this approach was not discussed in class 
        #  I learned this approach from geeksforgeeks

# // Your code here along with comments explaining your approach


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        # find pivot element where array is rotated
        pivot =  self.find_pivot(nums,left,right)
        # if array is not at all rotated so we will do general binary search
        if pivot == -1:
            return self.binary_search(left,right,nums,target)
        # if element is pivot element return pivot
        if nums[pivot] == target :
            return pivot
#         search in left (left ... pivot-1)
        if nums[0] <=  target:
            return self.binary_search(0, pivot - 1, nums, target)
        else :
            return self.binary_search(pivot+1, len(nums)-1, nums, target)

#         search in right (pivot +1 .... right)

    def binary_search(self, left, right, nums, target):
        while (left <= right ):
            mid = ( left + right ) / 2
            if(nums[mid] ==  target ) :
                return mid
            elif nums[mid] > target :
                return self.binary_search(left, mid-1, nums, target)
            elif nums[mid] < target :
                return self.binary_search(mid+1, right, nums, target)
    
             
        return  -1
#     3,4,5,6,1,2
    def find_pivot(self,nums, left, right):
        
#         base case
        if left > right :
            return  -1
        if left == right :
            return left
        
        
        while(left <= right) :
            mid = int((left + right)/2)
#             handling case like 4 5 6 7 0 1 2
#           rotated array is right side
            if( (mid < right ) and (nums[mid] > nums[mid+1]) ) :
                return mid + 1
#              handling case like 10 11 12 1 2 3 4
#               left side array is rotated
            elif (mid > left and nums[mid] < nums[mid-1]):
                return mid - 1
            elif (nums[left] >= nums[mid] ):
                return self.find_pivot(nums, left, mid-1)
            return self.find_pivot(nums,mid + 1, right)
            
        
    
        
        