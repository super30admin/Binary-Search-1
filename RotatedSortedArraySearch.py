class Solution:
    def search(self, nums:[int], target: int) -> int:
        if nums is None:
            return -1
        else:
            high = len(nums) - 1
            low = 0

            while low <= high:
                mid_index = (high + low) // 2
                if target == nums[mid_index]:
                    return mid_index
                elif nums[low] <= target <= nums[mid_index - 1]:
                    if mid_index > low:
                        high = mid_index - 1
                    else:
                        high = low
                else:
                    if mid_index < high:
                        low = mid_index + 1
                    else:
                        low = high

        return -1


nums = [4, 5, 6, 7, 0, 1, 2]
target = 0

r = Solution()
print(r.search(nums, target))
