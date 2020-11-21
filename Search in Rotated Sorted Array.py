class Solution:
    def search(self, nums, target):
        # find the smallest index.
        smallestIndex = self.smallestIndex(nums)
        # dedice on which half, to run the binary search

        if target <= nums[-1]:
            return self.binarySearch(nums, smallestIndex, len(nums)-1, target)
        else:
            return self.binarySearch(nums, 0, smallestIndex - 1, target)

    def smallestIndex(self, nums):
        low, high = 0, len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] < nums[high]:
                high = mid
            else: low = mid + 1
        return low


    def binarySearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if target == nums[mid]: return mid
            elif target < nums[mid]: high = mid -1
            else: low = mid + 1
        return -1


if __name__ == "__main__":
    nums = [4,5,6,7,0,1,2,3]
    target = 0
    print(Solution().search(nums, target)) #4
    print(Solution().search([6,7,1,2,3,4], 7)) #1
    print(Solution().search([70, 0], 0))  #1
    print(Solution().search([1,3], 3)) #1
    print(Solution().search([8,9,1,2,4], 10)) #-1