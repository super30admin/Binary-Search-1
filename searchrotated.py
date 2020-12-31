'''
Time complexity O(logn)
Space complexity O(1)
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 0 : return -1 # as no elements in the array
        low  = 0 
        high  =  n -1
        while (low <= high): 
            mid = low  + (high - low) //2
            # base case
            if nums[mid] == target: return mid
            # case 1 if left part is sorted
            if nums[low] <= nums[mid]:                                     #catch ""<="" you can have same elements like ( 1,1,1,1,1) 
                # case 1.1 if target is in sorted left part
                if target >= nums[low] and target <= nums[mid]:
                    return self.bs(nums,low,mid,target)
                # case 1.2 if target is not in sorted left part
                else:
                    low = mid + 1
            # case 2 if right part is sorted
            if nums[mid] <= nums[high]:
                # case 2.1 if target is in sorted right part
                if target >= nums[mid] and target <= nums[high]:
                    return self.bs(nums,mid,high,target)
                # case 2.2 if target is not in sorted right part
                else:
                    high = mid-1
        return -1
    
    def bs(self,nums,low,high,target):
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target: return mid
            if target < nums[mid]: high = mid-1
            else: low = mid + 1
        return -1
                