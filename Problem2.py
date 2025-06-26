class Solution(object):
    def search(self, nums, target):
        l = 0
        h = len(nums) - 1

        while l <= h:
            mid_index = (l+h)//2
            mid = nums[mid_index]

            if target == mid:
                return mid_index
            
            elif nums[l] <= mid :
                if nums[l] < target < mid :
                    h = mid_index - 1
                else:
                    l = mid_index + 1

            else:
                if mid < target < nums[h]:
                    l = mid_index + 1
                else:
                    h = mid_index - 1 
        return -1
