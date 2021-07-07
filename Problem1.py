# // Time Complexity: O(logn)
# // Space Complexity: O(1)
# // Did this code successfully run on Leetcode: Yes
# // Any problem you faced while coding this: NO


# // Your code here along with comments explaining your approach


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1
        while(l <= r):
            mid = l+(r-l)//2
            #element is found
            if nums[mid] == target:
                return mid
            #element is smaller
            if nums[mid] >= nums[0]:
                #in non roateted part 
                if target < nums[mid] and target >= nums[0]:
                    r = mid-1
                else:
                    #in roateted part
                    l = mid+1
            else:
                #in non roateted part
                if target > nums[mid] and target <= nums[-1]:
                    l = mid+1
                else:
                    #in roateted part
                    r = mid-1
        return -1
