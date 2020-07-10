# Time Complexity : O(log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
## Tried both the iterative and recursive solution with one pass binary search.
## This would not work for the some cases with repeated numbers. Better approach would be 2 pass binary search.
## First pass to get the starting element and second pass to get the target.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        ## one pass bnary search approach
        if not nums:
            return -1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r-l) // 2
            if nums[mid] == target:
                return mid
            if nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1
                

        ## recursive approach:
        
        # def searchTarget(l, r):
        #     if l > r:
        #         return -1
        #     mid = l + (r-l) // 2
        #     if nums[mid] == target:
        #         return mid
        #     elif nums[l] <= nums[mid]:
        #             if nums[l] <= target < nums[mid]:
        #                 return searchTarget(l, mid - 1)
        #             else:
        #                 return searchTarget(mid +1, r)
        #     else:
        #             if nums[mid] < target <= nums[r]:
        #                 return searchTarget(mid +1, r)
        #             else:
        #                 return searchTarget(l, mid - 1)
        # return searchTarget(0, len(nums) - 1)                 

# Time Complexity : O(log M). Here M is the index of the target in the array.
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

## First finding the window where the target should be by increasing the high index to double of high and low to high.
## Once the window is found applying binary search.
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 1
        while reader.get(high) < target:
            low, high = high, 2*high
        
        while low <= high:
            mid = low + (high-low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        