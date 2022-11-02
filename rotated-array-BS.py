# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no 
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        mini, min_index = min(nums), nums.index(min(nums))
        nums_dupe = []
        nums_dupe.extend(nums[min_index:])
        nums_dupe.extend(nums[0:min_index])
        # print(nums_dupe)
        f = 0
        l = len(nums)-1
        while f<=l:
            mid = f + (l - f)//2 # (f+l)//2
            # print(mid, f, l)
            if nums_dupe[mid]>target:
                l = mid - 1
            elif nums_dupe[mid]<target:
                f = mid + 1
            if nums_dupe[mid]==target:
                # print("pk", nums_dupe[mid])
                return (mid+min_index)%len(nums)
        return -1