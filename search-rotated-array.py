# Complexity: O(log n)
class Solution(object):
    # 1.Initialize low and high
    # 2. Start binary search
    # 2.1 Check if left is sorted
    # 2.2 Check if right is sorted
    def searchRotatedArray(self, matrix, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return True
            else:
                # 2.1
                if nums[low] <= nums[mid]: # = because low and mid can point to the target 
                    if target >= nums[low] and target < nums[mid]: # checks if target is on this side
                        high = mid - 1
                    else:
                        low = mid + 1
                # 2.2
                else:
                    if target <= nums[low] and target > nums[mid]:
                        low = mid + 1
                    else:
                        high = mid - 1
        return -1