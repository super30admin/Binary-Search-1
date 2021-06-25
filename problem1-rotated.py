class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums or len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = int(low + (high-low)/2)
            
            if nums[mid] == target:
                return mid
            #left side sorted
            if nums[low] <= nums[mid]:
                #target on sorted side
                if nums[low] <= target and nums[mid] > target:
                    high = mid-1
                #unsorted side
                else:
                    low = mid+1
            #right side sorted
            elif nums[mid] <= nums[high]:
                if nums[mid] < target and nums[high] >= target:
                    low= mid+1
                else:
                    high = mid-1
        return -1