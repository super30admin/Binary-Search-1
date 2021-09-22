class Solution:
    def find_rotation_index(self, nums, l, r, target):
        if nums[l] < nums[r]:
            return 0
        while l <= r:
            pi = (l+r)//2
            if nums[pi] == target:
                return pi
            elif nums[l] <= nums[pi]:
                if nums[l] <= target and target <= nums[pi]:
                    r = pi-1
                else:
                    l = pi + 1
            else:
                if nums[pi] <= target and target <= nums[r]:
                    l = pi+1
                else:
                    r = pi-1
        return -1

    def find_index_of_target(self, nums, l, r, target):
        while l <= r:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            else:
                if nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1

    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1
        n = len(nums)
        if n == 1 and nums[0] == target:
            return 0
        if n == 1 and nums[0] != target:
            return -1
        rotation_index = self.find_rotation_index(nums, 0, n-1, target)
        # print("rotation_index", rotation_index)
        if nums[rotation_index] == target:
            return rotation_index
        if rotation_index == 0:
            return self.find_index_of_target(nums, 0, r, target)
        if nums[0] > target:
            return self.find_index_of_target(nums, rotation_index, n-1, target)
        else:
            return self.find_index_of_target(nums, 0, rotation_index, target)
