

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        while nums[left] > nums[right]:
            left += 1
        start = left
        higher = nums[0:start]
        lower = nums[start:len(nums)]
        if target in higher:
            m = Solution.searchRangeHelper(0,len(higher)-1,higher,target)
        elif target in lower:
            m = Solution.searchRangeHelper(0,len(lower)-1,lower,target)
            m += len(higher)
        else:
            return -1
        return m

    def searchRangeHelper (left: int, right: int, nums: list[int], target: int):

        if right >= left:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return Solution.searchRangeHelper(left, mid-1, nums, target)
            else:
                return Solution.searchRangeHelper(mid+1, right, nums, target)

        else:
            return -1