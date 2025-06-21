# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def search(self, nums, target):
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) //2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if (target >= nums[low] and target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if (target <= nums[high] and target > nums[mid]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

obj = Solution()
output1 = obj.search([4,5,6,7,0,1,2], 0)
print(output1)
output2 = obj.search([4,5,6,7,0,1,2], 3)
print(output2)
output3 = obj.search([1],0)
print(output3)