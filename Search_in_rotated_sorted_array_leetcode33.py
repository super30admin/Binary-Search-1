class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # time complexity O(log(n))
        # space complexity O(1)
        def findPivot(nums):
            if nums[0] < nums[len(nums) - 1]:
                return 0

            left = 0
            right = len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > nums[mid + 1]:
                    return (mid + 1)
                elif nums[mid] < nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1

        def binSearch(left, right):
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid - 1
            return -1

        if len(nums) == 1:
            return 0 if target == nums[0] else -1

        pivot = findPivot(nums)

        if nums[0] < nums[len(nums) - 1]:
            left = 0
            right = len(nums) - 1
            return binSearch(left, right)

        elif target < nums[0]:
            left = pivot
            right = len(nums) - 1
            return binSearch(left, right)

        else:
            left = 0
            right = pivot - 1
            return binSearch(left, right)

