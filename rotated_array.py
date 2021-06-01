# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution(object):

    def search(self, nums, target):

        length_of_array = len(nums)

        low = 0
        high = length_of_array - 1

        while (low <= high):
            mid = low + (high - low) / 2

            if nums[mid] == target:
                return mid

            if nums[mid] >= nums[low]:
                #               Left hand side is sorted and right hande side is rotated
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                # Right hand side is sorted and Left hande side is rotated

                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
