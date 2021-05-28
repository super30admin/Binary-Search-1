class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums:
            low = 0
            high = len(nums)-1
            while low <= high:
                mid = low + (high - low)//2
                if nums[mid] == target:
                    return mid
                elif nums[low] <= nums[mid]: #checking if the left side is sorted
                    if target >= nums[low] and target < nums[mid]:
                        high = mid-1
                    else:
                        low = mid + 1
                else:
                    if target > nums[mid] and target <= nums[high]:
                        low = mid + 1
                    else:
                        high = mid - 1
            return -1
        else:
            return -1
                        
#time complexity is log(n) since we are rejecting half of the elements in the array at every search 
                        
                    