// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums ) -1
        if len(nums )= =0:
            return -1
        while lo w< =high:
            mid = lo w +(hig h -low )/ /2

            if nums[mid ]= =target:
                return mid
            # for left sorted
            elif nums[low ]< =nums[mid]:
                if nums[low ]< =target and nums[mid ] >target:
                    high = mi d -1
                else:
                    low = mi d +1
            # for right sorted
            else:
                if nums[mid ] <target and nums[high ]> =target:
                    low = mi d +1
                else:
                    high = mi d -1

        return -1