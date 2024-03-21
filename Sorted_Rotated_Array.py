class Solution(object):
    """
    Solution: Recursive
    1. The main idea of this problem is one half of the array is sorted and the other is unsorted and so check
        which part is sorted
    2. After knowing which part is sorted, check whether the target is in the sorted array or not
    3. Accordingly manipulate low and high values and call recursion on it.

    --- My solution passed all cases on Leetcode
    """
    def search_helper(self, nums, target, low, high):
        if (low > high):
            return -1
        mid = low + int((high - low) / 2)

        if (target == nums[mid]):
            return mid

        elif (nums[mid] >= nums[low]):
            if (target >= nums[low] and target < nums[mid]):
                high = mid - 1
            else:
                low = mid + 1

        else:
            if (target > nums[mid] and target <= nums[high]):
                low = mid + 1
            else:
                high = mid - 1

        return self.search_helper(nums, target, low, high)

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # O(logn) Time Complexity | O(logn) Space Complexity
        low = 0
        high = len(nums) - 1
        return self.search_helper(nums, target, low, high)

    def searchIterative(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
            Solution: Iterative
            1. The main idea of this problem is one half of the array is sorted and the other is unsorted and so check
                which part is sorted
            2. After knowing which part is sorted, check whether the target is in the sorted array or not
            3. Accordingly manipulate low and high values until low > high.

            --- My solution passed all cases on Leetcode
        """
        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + int((high - low) / 2)

            if (target == nums[mid]):
                return mid

            elif (nums[mid] >= nums[low]):
                if (target >= nums[low] and target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                if (target > nums[mid] and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1