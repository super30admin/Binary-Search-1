class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1

        while low <high:
            mid = low + (high - low)//2 #to take care of integer overflow    

            if nums[mid] == target:
                return mid
            #check left or right half is sorted
            if nums[low] <= nums[mid]:
                #now check if the target is in this range
                if nums[low] <= target and nums[mid]>target:
                    high = mid
                else:
                    low = mid+1

            else:
                #means right side is sorted in asc
                if nums[mid] < target and nums[high] >= target:
                    low = mid+1
                else:
                    high = mid
        if nums[low] == target:
            return low

        return -1        
    
# Time Complexity: O(logN)
# Space Complexity: O(1)