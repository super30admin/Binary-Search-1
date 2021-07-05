class Solution(object):
    
    def __get(self, nums, index):
        """
        Creating this function as private for abstraction
        """
        try:
            return nums[index]
        except IndexError:
            return 2147483647

    def binarySearch(self, nums, target):
        low = 0
        high = 1
        tempNum = self.__get(nums, high)
        while tempNum < target:
            low = high
            high = 2*high
            tempNum = self.__get(nums, high)
        print(low, high)
        
        while low <= high:
            mid = low + (high - low) // 2
            if target == self.__get(nums, mid):
                return mid
            elif target < self.__get(nums, mid):
                high = mid - 1
            else:
                low = mid + 1
        return -1

nums = [i for i in range(100)]
target = 99
obj = Solution()
print(obj.binarySearch(nums, target))