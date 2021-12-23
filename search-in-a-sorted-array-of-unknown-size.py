class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def binarySearch(target, row, low, high):
            while low <= high:
                mid = (low + high)//2
                if row[mid] == target: return mid
                elif row[mid] < target: low = mid + 1
                else: high = mid - 1
            return -1

        def split():
            low, high = 0, 1
            temp = nums[low]
            while temp < target:
                low = high
                high = 2*high
                temp = nums[high]
            return low, high

        try:
            low, high = split()
            return binarySearch(target, nums, low, high)
        except IndexError:
            print("Exception:Index out of bound")
        
        