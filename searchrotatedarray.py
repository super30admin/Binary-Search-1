class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        r = len(nums)
        if r == 0:
            return -1
        
        l = 0
        r = r - 1
        while l <= r:
            mid  = l + int((r - l)/2)
            if target == nums[mid]:
                return mid
            else:
                if nums[l] <= nums[mid]:
                    if target >= nums[l] and target < nums[mid]:
                        r = mid - 1
                    else:
                        l = mid + 1
                else:
                    if target > nums[mid] and target <= nums[r]:
                        l = mid + 1
                    else:
                        r = mid - 1
        return  -1            