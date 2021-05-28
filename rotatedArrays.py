# // Time Complexity : O(2log(n))
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def search(self, nums, target) -> int:

        low = 0
        high = len(nums) - 1

        while low < high:
            mid = int(low + (high - low) / 2)
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid

        rot_factor = low

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)
            real_mid = (mid + rot_factor) % (len(nums))
            if nums[real_mid] == target:
                return real_mid
            elif nums[real_mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


obj = Solution()
nums = [2,3,4,5,1]
target = 4
print(obj.search(nums,target))