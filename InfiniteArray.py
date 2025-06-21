# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution(object):
    def search(self, nums, target):
        if len(nums) == 0:
            return -1
        low = 0
        high = 1
        #Exponential search to finding bounds.
        while True:
            try:
                if nums[high] < target:
                    low = high
                    high = high * 2
                else:
                    break
            except IndexError:
                break
            #bineary search
        while low <= high:
            try:
                mid = low + (high - low) //2
                if nums[mid] == target:
                    return mid
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            except IndexError:
                high = mid - 1
        return -1