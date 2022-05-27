#time complexity: O(log n)
#space complexity: O(1)
#successfully ran on leetcode
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]: #left sorted
                if target<=nums[mid] and nums[low]<=target: 
                    high=mid-1
                else:
                    low=mid+1
            elif nums[mid]<=nums[high]: #right sorted
                if target>=nums[mid] and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
       
                
