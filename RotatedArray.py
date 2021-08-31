#Time Compelxity : O(logn)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : Was getting time exceeded initially, had to find a recursive solution
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n= len(nums)
        if n==1:
            return 0 if nums[0] == target else -1
        def get_ind(left,right):
            if nums[left] <nums[right]:
                return 0
            while left <= right:
                mid = (left+right)//2
                if nums[mid] > nums[mid+1]:
                    return mid+1
                else:
                    if nums[mid] <nums[left]:
                        right = mid-1
                    else:
                        left = mid+1
        def search(left,right):
            while left <= right:
                mid = (left+right)//2
                if nums[mid] == target:
                    return mid
                else:
                    if target <nums[mid]:
                        right = mid-1
                    else:
                        left = mid+1
            return -1
        index = get_ind(0,n-1)
        if target == nums[index]:
            return index
        if index == 0:
            return search(0,n-1)
        if target < nums[0]:
            return search(index,n-1)
        return search(0,index)
        
        
