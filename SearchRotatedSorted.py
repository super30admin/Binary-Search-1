# Time Complexity is O(logN) where N is the number of elements in array
# Space complexity is O(1)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low+high)//2
            if(nums[mid] == target):
                return mid
            # Check if left is sorted
            if(nums[low] <= nums[mid]):
                # It means Left array is sorted
                # Check if number exists in left side
                if(target >= nums[low] and target < nums[mid]):
                    high = mid-1
                # Check if number in right side
                else:
                    low = mid + 1
            else:
                # Right array is sorted
                if(target > nums[mid] and target <= nums[high]):
                    low = mid+1
                else:
                    high = mid-1
        return -1