# Time Complexity : log(N). Find the sorted side, eliminate either one based on the range for binary search 
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 33. Search in Rotated Sorted Array


def search(nums, target: int) -> int:
    low, high = 0, len(nums)-1
    
    while(low <= high):
        mid = low + (high-low)//2
        if target == nums[mid]:
            return mid
        elif nums[low] <= nums[mid]: #left side is sorted
            if nums[low] <= target and nums[mid] > target: #target is in the left sorted range
                high = mid -1
            else:
                low = mid + 1
        elif nums[high] >= nums[mid]: #right side is sorted
            if nums[mid] < target and nums[high] >= target:
                low = mid + 1
            else:
                high = mid - 1
    return -1

nums = [4,5,6,7,0,1,2]
target = 0
print(search(nums,target))
target = 8
print(search(nums,target))



