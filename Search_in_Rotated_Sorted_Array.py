class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            elif nums[mid]<target:
                if nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if nums[l] > target and nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid - 1
            
        return -1
                
                
        